package com.example.carwashwebappbackend.repository;

import com.example.carwashwebappbackend.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services, Integer> {
}
