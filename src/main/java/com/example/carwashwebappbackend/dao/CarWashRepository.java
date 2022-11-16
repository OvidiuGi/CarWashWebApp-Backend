package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.CarWash;
import org.springframework.data.repository.CrudRepository;

public interface CarWashRepository extends CrudRepository<CarWash, Integer> {
}
