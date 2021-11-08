package com.example.FitFat.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import com.example.FitFat.Models.LoginRequest;
import com.example.FitFat.Models.Trainee;
import com.example.FitFat.Models.Trainer;
import com.example.FitFat.Models.Users;
import com.example.FitFat.Repositories.TraineeRepository;
import com.example.FitFat.Repositories.TrainerRepository;
import com.example.FitFat.Repositories.UsersRepository;
import com.example.FitFat.Security.JwtResponse;
import com.example.FitFat.Security.JwtUtils;
import com.example.FitFat.Security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.sql.Date;
import java.time.LocalDate;


@CrossOrigin(origins = "*")
@Controller
public class GymAdminController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TraineeRepository traineeRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getFirstName(), userDetails.getLastName(), "", 5
                , roles));
    }


    @GetMapping("/")
    @ResponseBody
    public String home() {
        try {
            Trainer trainer = new Trainer("mamoon", encoder.encode("123456"), "mamoon", "huseein", Date.valueOf(LocalDate.now()), "mmm", "0789");
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
