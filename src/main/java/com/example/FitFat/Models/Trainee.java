package com.example.FitFat.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
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
    @JoinTable(name = "trainee_sessions",
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

    public Trainee(String name, String email, String phoneNumber, String img) {
        super(name, email, phoneNumber, img);
    }

    public Trainee(String name, String email, String phoneNumber, String img, String gender, String medicalStatus, Date subscriptionStart, Date endOFSubscription) {
        super(name, email, phoneNumber, img);
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

    public Date getSubscriptionStart() {
        return SubscriptionStart;
    }

    public void setSubscriptionStart(Date subscriptionStart) {
        SubscriptionStart = subscriptionStart;
    }

    public Date getEndOFSubscription() {
        return endOFSubscription;
    }

    public void setEndOFSubscription(Date endOFSubscription) {
        this.endOFSubscription = endOFSubscription;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

    public void subscribe(int length) {
        Calendar calendar = Calendar.getInstance();
        this.setSubscriptionStart(Date.valueOf(String.valueOf(calendar)));
        calendar.add(Calendar.MONTH, length);
        this.setEndOFSubscription(Date.valueOf(String.valueOf(calendar)));

    }
}
