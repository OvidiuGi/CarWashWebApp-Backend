package com.example.carwashwebappbackend.service;

import com.example.carwashwebappbackend.model.CarWash;
import com.example.carwashwebappbackend.repository.CarWashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarWashService {
    @Autowired
    private CarWashRepository carWashRepository;

    public List<CarWash> getCarwashes() {
        return carWashRepository.findAll();
    }

    public CarWash save(CarWash carWash) {
        return this.carWashRepository.save(carWash);
    }
}
