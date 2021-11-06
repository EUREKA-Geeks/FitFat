package com.example.FitFat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TrainerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String userName;

    private String firstName;
    private String lastName;
    private String password;
    private Date dateOfBirth;
    private String bio;
    private String email;
    private int phoneNumber;
    private String education;
    private String specialTraining; // or boolean?
    private String experience;
    private String gym;
    private String availability;
    private String users;
    private  String session;
    private int price;

    public TrainerModel(String userName, String firstName, String lastName, String password, Date dateOfBirth, String bio, String email, int phoneNumber, String education, String specialTraining, String experience, String gym, String availability, String users, String session, int price) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.education = education;
        this.specialTraining = specialTraining;
        this.experience = experience;
        this.gym = gym;
        this.availability = availability;
        this.users = users;
        this.session = session;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
