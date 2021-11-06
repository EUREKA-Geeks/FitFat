package com.example.FitFat.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class GymAdmin extends Users {


    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Gym getGym() {
        return gym;
    }


    public GymAdmin() {
    }

    public GymAdmin(String username, String password, String firstName, String lastName, Date DOB, String email, String phoneNumber) {
        super(username, password, firstName, lastName, DOB, email, phoneNumber);
    }
}
