package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.CarWashRepository;
import com.example.carwashwebappbackend.entity.CarWash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carwash")
@CrossOrigin(origins = "http://localhost:3000")
public class CarWashController {
    private CarWashRepository carWashRepository;

    @Autowired
    public CarWashController(CarWashRepository theCarWashRepository) { carWashRepository = theCarWashRepository;}

    @GetMapping()
    public @ResponseBody Iterable<CarWash> getCarWashes() { return carWashRepository.findAll(); }
}
