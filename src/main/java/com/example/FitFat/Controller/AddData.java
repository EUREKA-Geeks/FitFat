package com.example.FitFat.Controller;

import com.example.FitFat.Models.Gym;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AddData {

    @GetMapping("/add-gym")
    public String gym(Model model) {
        ArrayList l1 = new ArrayList();
        ArrayList l2 = new ArrayList();
        l1.add("Al-aayan street");
        l2.add("Abu Feras Al-Hamadani St., Amman");
        ArrayList f1 = new ArrayList();
        ArrayList f2 = new ArrayList();
        f1.add("Car Parkings");
        f2.add("Sauna");
        ArrayList<Gym> gymList = new ArrayList<>();
        gymList.add(new Gym("Gold", l1, "064001222", f1));
        gymList.add(new Gym("Doctor’s Gym - Inspo Fitness Clinic", l2, "07 9100 7000", f2));
        model.addAttribute("gym", gymList);
        return "gym";
    }
}
// name: Gold's Gym
//location: Al-aayan street
//phone number: 064001222
//sessions: kick boxing, pilates, material arts, aqua aerobics, boxing, zomba, yoga, body pump, body compat, body balance
//open hours: Tuesday	6AM–11PM
//Wednesday	6AM–11PM
//Thursday	6AM–11PM
//Friday	7AM–9PM
//Saturday	6AM–11PM
//Sunday	6AM–11PM
//Monday	6AM–11PM