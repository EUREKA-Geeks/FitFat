package com.example.FitFat.Repositories;

import com.example.FitFat.Models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    Trainee findUserById(Long id);

    Trainee findByEmail(String email);
}