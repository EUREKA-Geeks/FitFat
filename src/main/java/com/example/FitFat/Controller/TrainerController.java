//package com.example.FitFat.Controller;
//
//import com.example.FitFat.Models.Announcement;
//import com.example.FitFat.Models.Session;
//import com.example.FitFat.Models.Trainee;
//import com.example.FitFat.Models.Trainer;
//import com.example.FitFat.Repositories.AnnouncementRepository;
//import com.example.FitFat.Repositories.SessionRepository;
//import com.example.FitFat.Repositories.TraineeRepository;
//import com.example.FitFat.Repositories.TrainerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/trainer")
//public class TrainerController {
//    @Autowired
//    TrainerRepository trainerRepository;
//
//    @Autowired
//    AnnouncementRepository announcementRepository;
//
//    @Autowired
//    SessionRepository sessionRepository;
//    @Autowired
//    TraineeRepository traineeRepository;
//
//    //// the return type will be changing for methods, no testing
//
//    // Trainer can add announcement
//    @PostMapping("/addAnnouncement")
//    public ResponseEntity addAnnouncement(Principal principal, @RequestParam String body) {
//        // just to avoid conflict I add another constructor At the end of Announcement model .
//        // I add findByUsername method in trainerRepository
//        Trainer trainer = trainerRepository.findByUsername(principal.getName());
//        Announcement newAnnouncement = new Announcement(body, trainer);
//        trainer.announcements.add(newAnnouncement);
//        announcementRepository.save(newAnnouncement);
//        return ResponseEntity.ok(newAnnouncement);
//    }
//
//    //Trainer can add sessions
//    @GetMapping("/Addsession")
//    public List<Session> sessionList(@RequestParam(value = "id") Long sessionID) {
//        Trainer trainer = new Trainer();
//        // create add to session method in Trainer model
//        trainer.addSession(sessionRepository.findById(sessionID).get());
//        return trainer.getSession();
//    }
//
//    // A trainer can remove one of his Trainee
//    @GetMapping("/removeTrainee")
//    public List<Trainee> removeTrainee(@RequestParam(value = "id") Long traineeID) {
//        Trainer trainer = new Trainer();
//        // create add to session method in Trainer model
//        trainer.deleteTrainee(traineeRepository.findById(traineeID).get());
//        return trainer.getTrainee();
//    }
//
//    //Trainer can list his/her trainee
//    @GetMapping("/allTrainee")
//    public List<Trainee> GetAllTrainee() {
//        Trainer trainer = new Trainer();
//        return trainer.getTrainee();
//    }
//
//    @PostMapping("/signupTraniner")
//    public String signupTrainer(@RequestBody Trainer trainer) {
////        System.out.println(trainer);
////        trainer.setPassword(new BCryptPasswordEncoder().encode(trainer.getPassword()));
//        trainerRepository.save(trainer);
//        return "yes";
//    }
//
//}
