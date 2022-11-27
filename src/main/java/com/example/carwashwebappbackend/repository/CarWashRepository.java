package com.example.carwashwebappbackend.repository;

import com.example.carwashwebappbackend.model.CarWash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarWashRepository extends JpaRepository<CarWash, Integer> {
}
