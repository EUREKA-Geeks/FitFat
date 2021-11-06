package com.example.FitFat.Repositories;

import com.example.FitFat.Models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}