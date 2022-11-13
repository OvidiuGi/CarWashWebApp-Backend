package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.user.UserDAO;
import com.example.carwashwebappbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserDAO userDAO;

    @Autowired
    public UserRestController(UserDAO theUserDAO) {
        userDAO = theUserDAO;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
