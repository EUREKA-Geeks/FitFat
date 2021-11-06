package com.example.FitFat.Repositories;

import com.example.FitFat.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
   public Trainer findByUsername(String name);
}
