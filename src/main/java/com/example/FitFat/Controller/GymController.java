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
    public ResponseEntity addAnnouncement(@RequestParam String body,
                                          @RequestParam Trainer trainer,
                                          @RequestParam Gym gym){


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
    public ResponseEntity addSession(@RequestParam int capacity,
                                     @RequestParam String type,
                                     @RequestParam Date day,
                                     @RequestParam String location,
                                     @RequestParam Trainer trainer,
                                     @RequestParam List<Trainee> trainees,
                                     @RequestParam Gym gym){
        Session session = new Session(capacity, type, day, location, trainer, trainees, gym);
        session.setGym(gym);
        sessionRepository.save(session);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/remove-session")
    public List<Session> removeSession(@RequestParam (value = "id") Long sessionId){
        Gym gym = new Gym();
        gym.deleteSession(sessionRepository.getById(sessionId));
        return gym.getSessions();
    }

    @PostMapping("/add-trainer")
    public ResponseEntity addTrainer(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam Date DOB,
                                     @RequestParam String email,
                                     @RequestParam String phoneNumber,
                                     @RequestParam String bio,
                                     @RequestParam String education,
                                     @RequestParam String specialTraining,
                                     @RequestParam String experience,
                                     @RequestParam Gym gym,
                                     @RequestParam String availability,
                                     @RequestParam List<Trainee> trainee,
                                     @RequestParam List<Session> session,
                                     @RequestParam int price){
        Trainer trainer = new Trainer(username, password, firstName, lastName, DOB, email, phoneNumber, bio, education, specialTraining, experience, gym, availability, trainee, session, price);
        trainer.setGym(gym);
        trainerRepository.save(trainer);
        return ResponseEntity.ok(trainer);
    }

    @GetMapping("/remove-trainer")
    public List<Trainer> removeTrainer(@RequestParam (value = "id") Long trainerId){
        Gym gym = new Gym();
        gym.deleteTrainer(trainerRepository.getById(trainerId));
        return gym.getTrainers();
    }

    @PostMapping("/add-trainee")
    public ResponseEntity addTrainee(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam Date DOB,
                                     @RequestParam String email,
                                     @RequestParam String phoneNumber,
                                     @RequestParam String gender,
                                     @RequestParam String medicalStatus,
                                     @RequestParam Date subscriptionStart,
                                     @RequestParam Date endOFSubscription,
                                     @RequestParam Gym gym){
        Trainee trainee = new Trainee(username, password, firstName, lastName, DOB, email, phoneNumber, gender, medicalStatus, subscriptionStart, endOFSubscription);
        trainee.setGym(gym);
        traineeRepository.save(trainee);
        return ResponseEntity.ok(trainee);
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
    public ResponseEntity updateGym(@RequestParam String name,
                                    @RequestParam ArrayList<String> location,
                                    @RequestParam String phoneNumber,
                                    @RequestParam String bio,
                                    @RequestParam String photo,
                                    @RequestParam ArrayList<String> features,
                                    @RequestParam List<Trainee> trainees,
                                    @RequestParam List<Session> sessions,
                                    @RequestParam List<Trainer> trainers,
                                    @RequestParam ArrayList<String> openHours,
                                    @RequestParam List<Announcement> announcement,
                                    @RequestParam List<Users> admin){
        Gym gym = new Gym(name, location, phoneNumber, bio, photo, features, trainees,sessions, trainers, openHours, announcement, admin);
        gymRepository.save(gym);
        return ResponseEntity.ok(gym);
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
