package com.example.FitFat.Controller;


import com.example.FitFat.Models.Trainee;
import com.example.FitFat.Models.Trainer;
import com.example.FitFat.Models.Users;
import com.example.FitFat.Repositories.TraineeRepository;
import com.example.FitFat.Repositories.TrainerRepository;
import com.example.FitFat.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Controller
public class GymAdminController {


    @Autowired
    TraineeRepository traineeRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/")
    @ResponseBody
    public String home() {
        try {
            Trainer trainer = new Trainer("mamoon", "123456", "mamoon", "huseein", Date.valueOf(LocalDate.now()), "mmm", "0789");
            trainerRepository.save(trainer);
        } catch (Exception e) {
            System.out.println("Trainer");
        }
        try {
            Trainee trainee = new Trainee("maamoon", "123456", "mamoon", "huseein", Date.valueOf(LocalDate.now()), "mmaaaam", "0778");
            traineeRepository.save(trainee);
        } catch (Exception e) {
            System.out.println("Trainee");
        }
//        try {
//            GymAdmin gymAdmin1 = new GymAdmin("mawmoon", "123456", "mamoon", "huseein", Date.valueOf(LocalDate.now()), "mmaaawwwwaam", "0758");
//            gymAdminRepository.save(gymAdmin1);
//        } catch (Exception e) {
//            System.out.println("Gymadmin");
//        }

        return "Yes";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<Users> getAll() {
        System.out.println(traineeRepository.findAll());
        System.out.println(trainerRepository.findAll());
        return usersRepository.findAll();
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

//    @PostMapping("/signup")
//    public RedirectView signUpUser(@RequestBody GymAdmin gymAdmin) {
//        gymAdminRepository.save(gymAdmin);
//        return new RedirectView("/login");
//    }

    @GetMapping("/login")
    public String login() {

        return "login.html";
    }

//    @GetMapping("/profile")
//    public String getProfile(Model m, Principal principal) {
//        try {
//            GymAdmin user = gymAdminRepository.findByUsername(principal.getName());
//            m.addAttribute("user", user);
//            return "profile";
//        } catch (Exception e) {
//            return "error";
//        }
//    }
}
