package com.example.FitFat.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "session")
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int capacity;
    private String type;
    private Date day;
    private String location;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToMany(mappedBy = "sessions")
    private List<Trainee> trainee;

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Session() {
    }

    public Session(int capacity, String type, Date day, String location, Trainer trainer, List<Trainee> trainee) {
        this.capacity = capacity;
        this.type = type;
        this.day = day;
        this.location = location;
        this.trainer = trainer;
        this.trainee = trainee;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTrainee(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    public void add(Trainee trainee) {
        this.trainee.add(trainee);
    }

    public List<Trainee> getTrainee() {
        return trainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}