package com.example.FitFat.Repositories;

import com.example.FitFat.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findUserById(Long id);
}