package com.example.FitFat.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Announcement {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String body;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @CreationTimestamp
    private Timestamp createdAt;

    public Trainer getTrainer() {
        return trainer;
    }

    public Announcement() {
    }

    public Announcement(String body, Gym gym, Timestamp createdAt) {
        this.body = body;
        this.gym = gym;
        this.createdAt = createdAt;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Gym getGym() {
        return gym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Announcement(String body, Trainer trainer) {
        this.body = body;
        this.trainer = trainer;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

}