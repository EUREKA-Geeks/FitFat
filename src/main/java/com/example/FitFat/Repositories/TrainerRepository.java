package com.example.FitFat.Repositories;

import com.example.FitFat.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByUsername(String name);
    Trainer findUserById (Long id);
}
