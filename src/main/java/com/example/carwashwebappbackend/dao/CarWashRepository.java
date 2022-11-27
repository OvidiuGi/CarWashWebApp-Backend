package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.CarWash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarWashRepository extends JpaRepository<CarWash, Integer> {
}
