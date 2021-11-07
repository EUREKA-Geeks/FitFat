package com.example.FitFat.Controller;

import com.example.FitFat.Models.Gym;
import com.example.FitFat.Models.Trainee;
import com.example.FitFat.Models.Trainer;
import com.example.FitFat.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/trainee")
public class testingController {

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
    @GetMapping("/profil")
    public List<Trainee> getProfile() {

//            Trainee profile = traineeRepository.findByUsername(principal.getName());

//            model.addAttribute("profile", profile);
        return this.traineeRepository.findAll();
//





    }
    @GetMapping("/trainer")
    public List<Trainer> getTrainer() {

//            Trainee profile = traineeRepository.findByUsername(principal.getName());

//            model.addAttribute("profile", profile);
        return this.trainerRepository.findAll();
//





    }
    @GetMapping("/gym")
    public List<Gym> getGym() {
        Gym gym = new Gym("golden", "amman","07988888","golden is gold","photo","saona","man","8am-11pm","8am-11pm","ddddd","man");

//            Trainee profile = traineeRepository.findByUsername(principal.getName());

//            model.addAttribute("profile", profile);
        return gymRepository.findAll();
//





    }
}
