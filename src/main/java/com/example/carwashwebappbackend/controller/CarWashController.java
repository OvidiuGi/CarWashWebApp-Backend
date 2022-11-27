package com.example.carwashwebappbackend.controller;

import com.example.carwashwebappbackend.repository.CarWashRepository;
import com.example.carwashwebappbackend.repository.UserRepository;
import com.example.carwashwebappbackend.model.CarWash;
import com.example.carwashwebappbackend.service.CarWashService;
import com.example.carwashwebappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carwash")
@CrossOrigin(origins = "http://localhost:3000")
public class CarWashController {
    @Autowired
    private CarWashService carWashService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<CarWash> getCarWashes() {
        return carWashService.getCarwashes();
    }

    @GetMapping("/add")
    public CarWash testAdd() {
        CarWash carWash = new CarWash();
        carWash.setId(0);
        carWash.setAddress("Adresaaaa");
        carWash.setName("Numele");
        carWash.setOwner(userService.getById(2));
        return carWashService.save(carWash);
    }
}
