package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.CarWashRepository;
import com.example.carwashwebappbackend.dao.UserRepository;
import com.example.carwashwebappbackend.entity.CarWash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carwash")
@CrossOrigin(origins = "http://localhost:3000")
public class CarWashController {
    private final CarWashRepository carWashRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CarWashController(CarWashRepository theCarWashRepository) { carWashRepository = theCarWashRepository;}

    @GetMapping()
    public @ResponseBody Iterable<CarWash> getCarWashes() { return carWashRepository.findAll(); }

    @GetMapping("/add")
    public CarWash testAdd() {
        CarWash carWash = new CarWash();
        carWash.setId(0);
        carWash.setAddress("Adresaaaa");
        carWash.setName("Numele");
        carWash.setOwner(userRepository.getById(2));
        return carWashRepository.save(carWash);
    }
}
