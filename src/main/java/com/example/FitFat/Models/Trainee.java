package com.example.FitFat.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
public class Trainee extends Users {
    private String gender;
    private String medicalStatus;
    // the start and end of Subscribe
    private Date SubscriptionStart;
    private Date endOFSubscription;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToMany
    @JoinTable(name = "null_sessions",
            joinColumns = @JoinColumn(name = "trainee_id"),
            inverseJoinColumns = @JoinColumn(name = "sessions_id"))
    private List<Session> sessions;

    public Trainer getTrainer() {
        return trainer;
    }

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Gym getGym() {
        return gym;
    }

    public Trainee() {
    }

    public Trainee(String gender, String medicalStatus, Date subscriptionStart, Date endOFSubscription) {
        this.gender = gender;
        this.medicalStatus = medicalStatus;
        SubscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
    }

    public Trainee(String username, String password, String firstName, String lastName, Date DOB, String email, String phoneNumber) {
        super(username, password, firstName, lastName, DOB, email, phoneNumber);
    }

    public Trainee(String username, String password, String firstName, String lastName, Date DOB, String email, String phoneNumber, String gender, String medicalStatus, Date subscriptionStart, Date endOFSubscription) {
        super(username, password, firstName, lastName, DOB, email, phoneNumber);
        this.gender = gender;
        this.medicalStatus = medicalStatus;
        SubscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }
}
