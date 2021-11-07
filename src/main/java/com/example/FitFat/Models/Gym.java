package com.example.FitFat.Models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Table(name = "gym")
@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;
    private ArrayList<String> location = new ArrayList<>();
    private String phoneNumber;
    private String bio;
    private String photo;
    private ArrayList<String> features = new ArrayList<>();

    @OneToMany(mappedBy = "gym", orphanRemoval = true)
    private List<Trainee> trainees;

    @OneToMany(mappedBy = "gym", orphanRemoval = true)
    private List<Trainer> trainers;
    private ArrayList<String> openHours = new ArrayList<>();
    // this should be announcement class;
    @OneToMany(mappedBy = "gym", orphanRemoval = true)
    private List<Announcement> announcement;
    // this is a relation for class of admin for the gym

    @OneToMany(mappedBy = "gym", orphanRemoval = true)
    private List<GymAdmin> admin;

    public Gym(String name, ArrayList<String> location, String phoneNumber, String bio, String photo, ArrayList<String> features, List<Trainee> trainees, List<Trainer> trainers, ArrayList<String> openHours, List<Announcement> announcement, List<GymAdmin> admin) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.photo = photo;
        this.features = features;
        this.trainees = trainees;
        this.trainers = trainers;
        this.openHours = openHours;
        this.announcement = announcement;
        this.admin = admin;
    }

    public Gym(String name, ArrayList<String> location, String phoneNumber, ArrayList<String> features, List<Trainee> trainees, List<Trainer> trainers, ArrayList<String> openHours) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.features = features;
        this.trainees = trainees;
        this.trainers = trainers;
        this.openHours = openHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }

    public List<String> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(ArrayList<String> openHours) {
        this.openHours = openHours;
    }

    public void setAnnouncement(List<Announcement> announcement) {
        this.announcement = announcement;
    }

    public List<Announcement> getAnnouncement() {
        return announcement;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setAdmin(List<GymAdmin> admin) {
        this.admin = admin;
    }

    public List<GymAdmin> getAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}