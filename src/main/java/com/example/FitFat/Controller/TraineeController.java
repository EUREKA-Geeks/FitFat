package com.example.FitFat.Controller;

import com.example.FitFat.Models.*;
import com.example.FitFat.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
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



    @Autowired
    PasswordEncoder encoder;

    @GetMapping ("/profil")
    public String getProfile(Model model, Principal principal){
        try {
            Trainee profile = traineeRepository.findByUsername(principal.getName());
            model.addAttribute("profile",profile);
            return "yes";
        }catch (Exception e){
            return "profile is not exist";
        }

    }

    //to let the loggedin user to see the other profile
    @GetMapping ("/profile/{id}")
    public String getProfileByID(@PathVariable Long id,Principal principal,Model model){

        try {

            Trainee traineeProfile = traineeRepository.findByUsername(principal.getName());
            Users owner = usersRepository.findUserById(id);
            model.addAttribute("visitor", traineeProfile);
            model.addAttribute("owner", owner);

            return "yes";


        }catch (Exception e){
            return "the profile is not exist";
        }



    }

    //adding new gym to trainee
    @PostMapping ("/gym")
    @ResponseBody
    //    public Gym(String name, ArrayList<String> location, String phoneNumber, ArrayList<String> features, List<Trainee> trainees, List<Trainer> trainers, ArrayList<String> openHours) {
    public String subscribeToOneGym( Principal principal,@RequestParam(value="name") String name,
                                                         @RequestParam(value="location") ArrayList<String> location,
                                                        @RequestParam(value = "phoneNumber")String phoneNumber,
                                                         @RequestParam(value = "features")ArrayList<String> features,
                                                         @RequestParam(value = "trainees") List<Trainee> trainees,
                                                         @RequestParam(value = "trainers")List<Trainer> trainers,
                                                         @RequestParam(value = "openHours")ArrayList<String>openHours){

        try {
            Trainee loggedTrainee = traineeRepository.findByUsername(principal.getName());
            Gym gym = new Gym(name,location,phoneNumber,features,trainees,trainers,openHours);

            gymRepository.save(gym);

            return "yes";

        }catch (Exception e){
            return "you are not allowed";

        }

    }


    //to delete a gym
    @DeleteMapping("/deletegym/{id}")
//    @ResponseBody
    public String  deleteSubscribe(@PathVariable Long id, Principal principal ){
        try {
            Trainee loggedTrainee = traineeRepository.findByUsername(principal.getName());

            Gym gym = gymRepository.findGymById(id);
            gymRepository.delete(gym);
            return "yes";


        }catch (Exception e){
            return "cant delete the gym";
        }

    }
    //to add a trainer to trainee
    @PostMapping  ("/trainer")
    public String subscribeToTrainer(Principal principal,  @RequestParam(value="specialTraining") String specialTraining,
                                       @RequestParam(value="experience") String experience,
                                       @RequestParam(value = "gym") Gym gym,
                                       @RequestParam(value = "availability")String availability,
                                       @RequestParam(value = "trainee") List<Trainee> trainee,
                                       @RequestParam(value = "session")List<Session> session,
                                       @RequestParam(value ="price")int price){


        try {
            Trainee loggedTrainee = traineeRepository.findByUsername(principal.getName());
            Trainer trainer = new Trainer(specialTraining,experience,gym,availability,trainee,session,price);

            trainerRepository.save(trainer);
            return "yes";

        }catch (Exception e){
            return "you are not allowed";

        }

    }
    //to delete a trainer to trainee

    @DeleteMapping("/delete/{id}")
//    @ResponseBody
    public String  deleteTrainer(@PathVariable Long id, Principal principal ){
        try {
            Trainee loggedTrainee = traineeRepository.findByUsername(principal.getName());


            Trainer trainer = trainerRepository.findUserById(id);
            trainerRepository.delete(trainer);
            return "yes";


        }catch (Exception e){
            return "cant delete the trainer";
        }

    }
//    to add a session to trainee
    @PostMapping("/session")
    public String bookSession(Principal principal,  @RequestParam(value="capacity") int capacity,
                                                    @RequestParam(value="type") String type,
                                                    @RequestParam(value = "day") Date day,
                                                    @RequestParam(value = "location")String location,
                                                    @RequestParam(value = "trainer") Trainer trainer,
                                                    @RequestParam(value = "trainee")List<Trainee> trainee){
        try {
            Trainee loggedTrainee= traineeRepository.findByUsername(principal.getName());
            Session sessions = new Session(capacity,type, (java.sql.Date) day,location,trainer,trainee);

//            Session sessionsList = sessions.;

            sessionRepository.save(sessions);
            return "yes";


        }catch (Exception e){
            return "the session not found";
        }


    }

    //to see the trainee subscription start - end

    public String getSubTime(){

    return "yes";
    }







}
