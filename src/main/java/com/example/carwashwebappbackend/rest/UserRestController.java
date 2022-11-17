package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.UserRepository;
import com.example.carwashwebappbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {
    private UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @GetMapping()
    public @ResponseBody Iterable<User> findAll() { return userRepository.findAll(); }
}
