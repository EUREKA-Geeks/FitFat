package com.example.FitFat.Repositories;

import com.example.FitFat.Models.GymAdmin;
import com.example.FitFat.Models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee,Long> {

    Trainee findByUsername(String name);

    Trainee findUserById(Long id);
}