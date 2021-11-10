package com.example.FitFat.Controller;

import com.example.FitFat.Models.*;
import com.example.FitFat.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Calendar;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/trainee")
public class TraineeController {


    @Autowired
    TraineeRepository traineeRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    GymRepository gymRepository;
    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    SessionRepository sessionRepository;


    @GetMapping("/profile")
    public ResponseEntity getProfile(@RequestBody String email) {


        try {
            Trainee traineeProfile = traineeRepository.findByEmail(email);
            return ResponseEntity.ok(traineeProfile);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not found");
        }

    }


    @PostMapping("/signup")
    public ResponseEntity signupTrainee(@RequestBody Trainee trainee) {
        try {
            System.out.println(trainee);
            traineeRepository.save(trainee);
            return ResponseEntity.ok("Created");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Duplicate email");
        }
    }

    //adding new gym to trainee
    @PostMapping("/gym/{name}/{email}/{len}")
    public ResponseEntity subscribeToOneGym(@PathVariable String name, @PathVariable String email, @PathVariable int len
    ) {
        try {
            Trainee loggedTrainee = traineeRepository.findByEmail(email);
            loggedTrainee.setGym(gymRepository.findGymByName(name));
            loggedTrainee.subscribe(len);
            traineeRepository.save(loggedTrainee);

            return ResponseEntity.ok("Subs");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Can't subs");

        }

    }


    //to delete a gym
    @DeleteMapping("/deleteGym/{email}")
    public ResponseEntity deleteSubscribe(@PathVariable String email) {
        try {
            Trainee loggedTrainee = traineeRepository.findByEmail(email);
            loggedTrainee.setGym(null);
            loggedTrainee.setSubscriptionStart(null);
            loggedTrainee.setEndOFSubscription(null);
            traineeRepository.save(loggedTrainee);
            return ResponseEntity.ok("UnSubs");
        } catch (Exception e) {
            return ResponseEntity.ok().body("You are not a member");
        }

    }


    @PostMapping("/trainer/{trainerEmail}/{traineeEmail}")
    public ResponseEntity subscribeToTrainer(@PathVariable String trainerEmail, @PathVariable String traineeEmail) {
        try {
            Trainee trainee = traineeRepository.findByEmail(traineeEmail);
            trainee.setTrainer(trainerRepository.findUserByEmail(trainerEmail));
            traineeRepository.save(trainee);
            return ResponseEntity.ok("Added");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("You are not allowed");

        }

    }


    @DeleteMapping("/delete/{trainee}")
    public ResponseEntity deleteTrainer(@PathVariable String trainee) {
        try {
            Trainee loggedTrainee = traineeRepository.findByEmail(trainee);
            loggedTrainee.setTrainer(null);
            traineeRepository.save(loggedTrainee);
            return ResponseEntity.ok("Deleted");


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("You can't");
        }

    }


    @PostMapping("/session/{id}/{email}")
    public ResponseEntity bookSession(@PathVariable Long id, @PathVariable String email) {
        try {
            Trainee loggedTrainee = traineeRepository.findByEmail(email);
            loggedTrainee.addSession(sessionRepository.getById(id));
            traineeRepository.save(loggedTrainee);
            return ResponseEntity.ok("Subs");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was a problem");
        }
    }


    @GetMapping("/subs")
    public String getSubTime(@PathVariable String email) {
        Trainee trainee = traineeRepository.findByEmail(email);
        return String.valueOf(trainee.getSubscriptionStart());
    }


}
