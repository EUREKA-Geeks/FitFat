package com.example.FitFat.Controller;

import com.example.FitFat.Models.Users;
import com.example.FitFat.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable Long id) {
        return usersRepository.findById(id).get();
    }

    //sign up new User with redirect login


    //User can edit his profile
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody Users users) {
//        Users updateUser = usersRepository.findById(id).get();
//        updateUser.setUsername(users.getUsername());
//        updateUser.setPassword(users.getPassword());
//        updateUser.setFirstName(users.getFirstName());
//        updateUser.setLastName(users.getLastName());
//        updateUser.setDOB(users.getDOB());
//        updateUser.setEmail(users.getEmail());
//        updateUser.setPhoneNumber(users.getPhoneNumber());
//        updateUser = usersRepository.save(users);
        usersRepository.save(users);
        return ResponseEntity.ok(users);
    }


}
