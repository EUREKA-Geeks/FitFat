package com.example.FitFat.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
public class Trainer extends Users {
    private String bio;
    private String education;
    private String specialTraining;
    private String experience;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private String availability;

    @OneToMany(mappedBy = "trainer", orphanRemoval = true)
    private List<Trainee> trainee;


    @OneToMany(mappedBy = "trainer", orphanRemoval = true)
    private List<Session> session;
    private int price;

    @OneToMany(mappedBy = "trainer", orphanRemoval = true)
    public List<Announcement> announcements;

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setTrainee(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    public List<Trainee> getTrainee() {
        return trainee;
    }


    public Trainer() {

    }

    public Trainer(String bio, String education, String specialTraining, String experience, Gym gym, String availability, List<Trainee> trainee, List<Session> session, int price) {
        this.bio = bio;
        this.education = education;
        this.specialTraining = specialTraining;
        this.experience = experience;
        this.gym = gym;
        this.availability = availability;
        this.trainee = trainee;
        this.session = session;
        this.price = price;
    }

    public Trainer(String specialTraining, String experience, Gym gym, String availability, List<Trainee> trainee, List<Session> session, int price) {
        this.specialTraining = specialTraining;
        this.experience = experience;
        this.gym = gym;
        this.availability = availability;
        this.trainee = trainee;
        this.session = session;
        this.price = price;
    }

    public Trainer(String username, String password, String firstName, String lastName, Date DOB, String email, String phoneNumber) {
        super(username, password, firstName, lastName, DOB, email, phoneNumber);
    }

    public Trainer(String username, String password, String firstName, String lastName, Date DOB, String email, String phoneNumber, String bio, String education, String specialTraining, String experience, Gym gym, String availability, List<Trainee> trainee, List<Session> session, int price) {
        super(username, password, firstName, lastName, DOB, email, phoneNumber);
        this.bio = bio;
        this.education = education;
        this.specialTraining = specialTraining;
        this.experience = experience;
        this.gym = gym;
        this.availability = availability;
        this.trainee = trainee;
        this.session = session;
        this.price = price;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpecialTraining() {
        return specialTraining;
    }

    public void setSpecialTraining(String specialTraining) {
        this.specialTraining = specialTraining;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


    public void addTrainee(Trainee trainee) {
        this.trainee.add(trainee);
    }


    public List<Session> getSession() {
        return session;
    }

    public void setSession(List<Session> session) {
        this.session = session;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
