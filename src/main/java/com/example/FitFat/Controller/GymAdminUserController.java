package com.example.FitFat.Controller;

import com.example.FitFat.Model.GymAdminUser;
import com.example.FitFat.Repository.GymAdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class GymAdminUserController {

    @Autowired
    GymAdminUserRepository gymAdminUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(@RequestParam(value="username") String username,
                                   @RequestParam(value="password") String password,
                                   @RequestParam(value = "firstname")String firstName,
                                   @RequestParam(value = "lastname")String lastName,
                                   @RequestParam(value = "dob") String dob,
                                   @RequestParam(value = "e_mail") String e_mail,
                                   @RequestParam(value = "phoneNum") String phoneNum)

    {//String username, String password, String firstName, String lastName, String dob, String e_mail, String phoneNum)

        GymAdminUser newAdminUser = new GymAdminUser(username, encoder.encode(password),firstName,lastName,dob,e_mail,phoneNum);
//        System.out.println(newAppUser.toString());
        GymAdminUserRepository.save(newAdminUser);
        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String login(){

        return "login.html";
    }

    @GetMapping("/profile")
    public String getProfile(Model m, Principal principal) {
        try {
            GymAdminUser user = GymAdminUserRepository.findByUsername(principal.getName());
            m.addAttribute("user", user);
            return "profile";
        } catch (Exception e) {
            return "error";
        }
    }
}
