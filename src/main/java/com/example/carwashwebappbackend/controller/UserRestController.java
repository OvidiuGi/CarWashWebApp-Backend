package com.example.carwashwebappbackend.controller;

import com.example.carwashwebappbackend.repository.UserRepository;
import com.example.carwashwebappbackend.model.User;
import com.example.carwashwebappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }
}
