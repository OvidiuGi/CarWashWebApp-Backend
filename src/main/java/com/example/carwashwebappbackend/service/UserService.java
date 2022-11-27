package com.example.carwashwebappbackend.service;

import com.example.carwashwebappbackend.model.User;
import com.example.carwashwebappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getById(Integer id) {
        return this.userRepository.getById(id);
    }
}
