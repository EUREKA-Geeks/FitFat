package com.example.FitFat.Controller;

import com.example.FitFat.Models.Announcement;
import com.example.FitFat.Models.Session;
import com.example.FitFat.Models.Trainee;
import com.example.FitFat.Models.Trainer;
import com.example.FitFat.Repositories.AnnouncementRepository;
import com.example.FitFat.Repositories.SessionRepository;
import com.example.FitFat.Repositories.TraineeRepository;
import com.example.FitFat.Repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    AnnouncementRepository announcementRepository;

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    TraineeRepository traineeRepository;

    //// the return type will be changing for methods, no testing

    // Trainer can add announcement
    @PostMapping("/add-announcement/{email}")
    public ResponseEntity addAnnouncement(@PathVariable String email, @RequestBody Announcement announcement ) {
//         just to avoid conflict I add another constructor At the end of Announcement model .
//         I add findByUsername method in trainerRepository
        try{
            Trainer trainer = trainerRepository.findByEmail(email);
            announcement.setTrainer(trainer);
            announcementRepository.save(announcement);
            return ResponseEntity.ok().body(announcement);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("The user is not found");
        }
    }

    //Trainer can add sessions
    @PostMapping("/add-session/{email}")
    public ResponseEntity sessionList(@PathVariable String email, @RequestBody Session session) {
        try{
            Trainer trainer = trainerRepository.findByEmail(email);
            // create add to session method in Trainer model
            session.setTrainer(trainer);
            sessionRepository.save(session);
            return ResponseEntity.ok().body(session);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("The user is not found");
        }
    }

    // A trainer can remove one of his Trainee
    @DeleteMapping("/removeTrainee/{trainee}")
    public ResponseEntity deleteTrainer(@PathVariable String trainee) {
        try {
            Trainee newTrainee = traineeRepository.findByEmail(trainee);
            newTrainee.setTrainer(null);
            traineeRepository.save(newTrainee);
            return ResponseEntity.ok("Deleted");


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("You can't");
        }

    }
    //Trainer can list his/her trainee
    @GetMapping("/all-trainee/{email}")
    public List<Trainee> GetAllTrainee(@PathVariable String email) {
        return trainerRepository.findByEmail(email).getTrainee();
    }


}
