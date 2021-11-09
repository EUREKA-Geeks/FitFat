package com.example.FitFat.Repositories;

import com.example.FitFat.Models.Trainer;
import com.example.FitFat.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findUserById (Long id);
}
