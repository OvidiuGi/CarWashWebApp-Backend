package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.CarWashRepository;
import com.example.carwashwebappbackend.entity.CarWash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carwash")
public class CarWashController {
    private CarWashRepository carWashRepository;

    @Autowired
    public CarWashController(CarWashRepository theCarWashRepository) { carWashRepository = theCarWashRepository;}

    @GetMapping()
    public @ResponseBody Iterable<CarWash> getCarWashes() { return carWashRepository.findAll(); }
}
