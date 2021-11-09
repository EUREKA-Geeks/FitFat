package com.example.FitFat.Controller;

import com.example.FitFat.Models.*;
import com.example.FitFat.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Calendar;

@CrossOrigin(origins = "http://localhost:3000")
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
    public Trainee getProfile(@RequestBody String email) {
        Trainee traineeProfile = traineeRepository.findByemail(email);

        try {
            return traineeProfile;


        } catch (Exception e) {
            return traineeProfile;
        }

    }

    //to let the loggedin user to see the other profile
//    @GetMapping("/profile/{id}")
//    public String getProfileByID(@PathVariable Long id,String email) {
//
//        try {
//
//            Trainee traineeProfile = traineeRepository.findByemail(email);
//            Users owner = usersRepository.findUserById(id);
//
//
//            return "yes";
//
//
//        } catch (Exception e) {
//            return "the profile is not exist";
//        }
//
//
//    }

    @PostMapping("/signup")
    public String signupTrainee(@RequestBody Trainee trainee) {
        System.out.println(trainee);
        traineeRepository.save(trainee);
        return "yes";
    }

    //adding new gym to trainee
    @PostMapping("/gym")
    //    public Gym(String name, ArrayList<String> location, String phoneNumber, ArrayList<String> features, List<Trainee> trainees, List<Trainer> trainers, ArrayList<String> openHours) {
    public Object subscribeToOneGym( @RequestBody Gym gym, String email
//                                    @RequestParam(value = "name") String name,
//                                    @RequestParam(value = "location") ArrayList<String> location,
//                                    @RequestParam(value = "phoneNumber") String phoneNumber,
//                                    @RequestParam(value = "features") ArrayList<String> features,
//                                    @RequestParam(value = "trainees") List<Trainee> trainees,
//                                    @RequestParam(value = "trainers") List<Trainer> trainers,
//                                    @RequestParam(value = "openHours") ArrayList<String> openHours
    ) {

        Trainee loggedTrainee = traineeRepository.findByemail(email);

        try {
            loggedTrainee.setGym(gym);
            Calendar calendar = Calendar.getInstance();
            loggedTrainee.setSubscriptionStart(java.sql.Date.valueOf(String.valueOf(calendar)));
            calendar.add(Calendar.MONTH, 1);
            loggedTrainee.setEndOFSubscription(java.sql.Date.valueOf(String.valueOf(calendar)));
            traineeRepository.save(loggedTrainee);

            return loggedTrainee;

        } catch (Exception e) {
            return "you are not allowed to add this gym";

        }

    }


    //to delete a gym
    @DeleteMapping("/deleteGym/{gym}")
    public Object deleteSubscribe(@RequestParam(value = "gym") Gym gym, String email) {
        try {
            Trainee loggedTrainee = traineeRepository.findByemail(email);
            loggedTrainee.setGym(null);
            loggedTrainee.setSubscriptionStart(null);
            loggedTrainee.setEndOFSubscription(null);
            traineeRepository.save(loggedTrainee);
            return loggedTrainee;


        } catch (Exception e) {
            return "cant delete the gym";
        }

    }

    //to add a trainer to trainee
    @PostMapping("/trainer")
    public Object subscribeToTrainer( @RequestBody Trainer trainer,String email
//                                     @RequestParam(value = "specialTraining") String specialTraining,
//                                     @RequestParam(value = "experience") String experience,
//                                     @RequestParam(value = "gym") Gym gym,
//                                     @RequestParam(value = "availability") String availability,
//                                     @RequestParam(value = "trainee") List<Trainee> trainee,
//                                     @RequestParam(value = "session") List<Session> session,
//                                     @RequestParam(value = "price") int price
    ) {


        try {
            Trainee loggedTrainee = traineeRepository.findByemail(email);
            loggedTrainee.setTrainer(trainer);
            traineeRepository.save(loggedTrainee);
            return loggedTrainee;

        } catch (Exception e) {
            return "you are not allowed";

        }

    }
    //to delete a trainer to trainee

    @DeleteMapping("/delete/{trainer}")
//    @ResponseBody
    public Object deleteTrainer(@RequestParam(value = "trainer") Trainer trainer, String email) {
        try {
            Trainee loggedTrainee = traineeRepository.findByemail(email);
            loggedTrainee.setTrainer(null);
            traineeRepository.save(loggedTrainee);
            return loggedTrainee;


        } catch (Exception e) {
            return "cant delete the trainer";
        }

    }

    // to add a session to trainee
    @PostMapping("/session")
    public Object bookSession(String email, @RequestBody Session session
//                              @RequestParam(value = "capacity") int capacity,
//                              @RequestParam(value = "type") String type,
//                              @RequestParam(value = "day") Date day,
//                              @RequestParam(value = "location") String location,
//                              @RequestParam(value = "trainer") Trainer trainer,
//                              @RequestParam(value = "trainee") List<Trainee> trainee
    ) {
        try {
            Trainee loggedTrainee = traineeRepository.findByemail(email);
            loggedTrainee.addSession(session);
            traineeRepository.save(loggedTrainee);
//            Session sessionsList = sessions.;

            return loggedTrainee;


        } catch (Exception e) {
            return "the session not found";
        }


    }

    //to see the trainee subscription start - end
    @GetMapping("subs")
    public String getSubTime(@RequestBody String email) {
        Trainee trainee = traineeRepository.findByemail(email);
        return String.valueOf(trainee.getSubscriptionStart());
    }


}
