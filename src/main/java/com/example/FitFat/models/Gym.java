package com.example.FitFat.models;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name = "gym")
@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int capacity;
    private String location;
    private String phoneNumber;
    private String bio;
    private String photo;
    private ArrayList<String> feature;
    // this a relation between trainers for now it's a string.
    private String trainers;
    private ArrayList<String> openHours;
    // this should be announcement class;
    private String announcement;
    // this is a relation for class of admin for the gym
    private String admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}