package com.example.FitFat.Controller;


import com.example.FitFat.Models.*;
import com.example.FitFat.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/add-announcement")
    public ResponseEntity addAnnouncement(@RequestBody String body,
                                          @RequestBody Trainer trainer,
                                          @RequestBody Gym gym){


        Announcement announcement = new Announcement(body, trainer);
        announcement.setGym(gym);
        announcementRepository.save(announcement);
        return ResponseEntity.ok(announcement);
    }

    @GetMapping("/remove-announcement")
    public List<Announcement> removeAnnouncement(@RequestParam (value = "id") Long announcementId){
        Gym gym = new Gym();
        gym.deleteAnnouncement(announcementRepository.getById(announcementId));
        return gym.getAnnouncement();
    }


    @PostMapping("/add-session")
    public ResponseEntity addSession(@RequestBody Gym gym,
                                     @RequestBody Session session){
        Session session1 = session;
        session1.setGym(gym);
        sessionRepository.save(session1);
        return  ResponseEntity.ok(session1);
    }

    @GetMapping("/remove-session")
    public List<Session> removeSession(@RequestParam (value = "id") Long sessionId){
        Gym gym = new Gym();
        gym.deleteSession(sessionRepository.getById(sessionId));
        return gym.getSessions();
    }

    @PostMapping("/add-trainer")
    public ResponseEntity addTrainer(@RequestBody Trainer trainer,
                                     @RequestBody Gym gym){
        Trainer trainer1 = trainer;
        trainer1.setGym(gym);
        trainerRepository.save(trainer1);
        return ResponseEntity.ok(trainer1);
    }

    @GetMapping("/remove-trainer")
    public List<Trainer> removeTrainer(@RequestParam (value = "id") Long trainerId){
        Gym gym = new Gym();
        gym.deleteTrainer(trainerRepository.getById(trainerId));
        return gym.getTrainers();
    }



    @PostMapping("/add-trainee")
    public ResponseEntity addTrainee(@RequestBody Trainee trainee,
                                     @RequestBody Gym gym){
        Trainee trainee1 = trainee;
        trainee.setGym(gym);
        traineeRepository.save(trainee1);
        return ResponseEntity.ok(trainee1);
    }

    @GetMapping("/remove-trainee")
    public List<Trainee> removeTrainee(@RequestParam (value = "id") Long traineeId){
        Gym gym = new Gym();
        gym.deleteTrainee(traineeRepository.getById(traineeId));
        return gym.getTrainees();
    }

    // list trainees
    @GetMapping("/all-trainees")
    public List<Trainee> getTrainees(){
        Gym gym = new Gym();
        return gym.getTrainees();
    }

    // list trainers
    @GetMapping("/all-trainers")
    public List<Trainer> getTrainers(){
        Gym gym = new Gym();
        return gym.getTrainers();
    }

    @PutMapping("/update-gym")
    public ResponseEntity updateGym(@RequestBody Gym gym){
        Gym gym1 = new Gym();
        gymRepository.save(gym1);
        return ResponseEntity.ok(gym1);
    }

    @PutMapping ("/update-subscription")
    public ResponseEntity updateSubscription(@RequestParam Date subscriptionStart,
                                             @RequestParam Date endOFSubscription){
        Trainee trainee = new Trainee(subscriptionStart, endOFSubscription);
        traineeRepository.save(trainee);
        return ResponseEntity.ok(trainee);
    }

    @PostMapping ("add-admin")
    public ResponseEntity addAdmin(@RequestParam List<Users> admin){
        Gym gym = new Gym();
        gymRepository.save(gym);
        return ResponseEntity.ok(gym);
    }
}
