package com.example.FitFat.Controller;


import com.example.FitFat.Models.*;
import com.example.FitFat.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gym")
public class GymController {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private GymRepository gymRepository;

    @PostMapping("/add-announcement/{name}")
    public ResponseEntity addAnnouncement(@RequestBody Announcement announcement, @PathVariable String name) {
        try {
            Gym gym = gymRepository.findGymByName(name);
            announcement.setGym(gym);
            announcementRepository.save(announcement);
            return ResponseEntity.ok().body(announcement);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was an error");
        }
    }

    @DeleteMapping("/remove-announcement/{id}")
    public ResponseEntity removeAnnouncement(@PathVariable String name, @PathVariable Long id) {
        try {
            announcementRepository.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }


    }


    @PostMapping("/add-session/{name}")
    public ResponseEntity addSession(@PathVariable String name,
                                     @RequestBody Session session) {
        try {
            Gym gym = gymRepository.findGymByName(name);
            session.setGym(gym);
            sessionRepository.save(session);
            return ResponseEntity.ok(session);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was an error ");
        }

    }

    @DeleteMapping("/remove-session/{id}")
    public ResponseEntity removeSession(Long id) {
        try {
            sessionRepository.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was an error");
        }
    }

    @PostMapping("/add-trainer/{name}/{email}")
    public ResponseEntity addTrainer(@PathVariable String email, @PathVariable String name) {
        try {
            Trainer trainer = trainerRepository.findUserByEmail(email);
            trainer.setGym(gymRepository.findGymByName(name));
            trainerRepository.save(trainer);
            return ResponseEntity.ok(trainer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was an error");
        }

    }

    @DeleteMapping("/remove-trainer/{email}")
    public ResponseEntity removeTrainer(@PathVariable String email) {
        try {
            Trainer trainer = trainerRepository.findUserByEmail(email);
            trainer.setGym(null);
            trainerRepository.save(trainer);
            return ResponseEntity.ok("Yes");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Not Found");
        }
    }


    @PostMapping("/add-trainee/{name}/{email}")
    public ResponseEntity addTrainee(@PathVariable String name, @PathVariable String email) {
        try {
            Trainee trainee = traineeRepository.findByEmail(email);
            Gym gym = gymRepository.findGymByName(name);
            trainee.setGym(gym);
            traineeRepository.save(trainee);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Not found");
        }
    }

    @GetMapping("/remove-trainee/{email}")
    public ResponseEntity removeTrainee(@PathVariable String email) {
        try {
            Trainee trainee = traineeRepository.findByEmail(email);
            trainee.setGym(null);
            traineeRepository.save(trainee);
            return ResponseEntity.ok("Removed");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Not Found");
        }
    }

    // list trainees
    @GetMapping("/all-trainees/{name}")
    public List<Trainee> getTrainees(@PathVariable String name) {
        return gymRepository.findGymByName(name).getTrainees();
    }

    // list trainers
    @GetMapping("/all-trainers/{name}")
    public List<Trainer> getTrainers(@PathVariable String name) {
        return gymRepository.findGymByName(name).getTrainers();
    }

    @PutMapping("/update-gym/{name}")
    public ResponseEntity updateGym(@RequestBody Gym gym, @PathVariable String name) {
        try {
            Gym gym1 = gymRepository.findGymByName(name);
            gym1 = gym;
            gymRepository.save(gym1);
            return ResponseEntity.ok().body("Updated");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Not working");
        }
    }

    @PutMapping("/update-subscription/{email}/{len}")
    public ResponseEntity updateSubscription(@PathVariable String email, @PathVariable int len) {
        try {
            Trainee trainee = traineeRepository.findByEmail(email);
            trainee.subscribe(len);
            traineeRepository.save(trainee);
            return ResponseEntity.ok(trainee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was an error");
        }
    }

    @PostMapping("add-admin/{name}/{email}")
    public ResponseEntity addAdmin(@PathVariable String name, @PathVariable String email) {
        try {
            Users users = usersRepository.findByEmail(email);
            users.setGym(gymRepository.findGymByName(name));
            return ResponseEntity.ok().body("Added gym");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("No");
        }
    }

}
