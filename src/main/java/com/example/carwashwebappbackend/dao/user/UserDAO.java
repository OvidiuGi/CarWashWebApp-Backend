package com.example.carwashwebappbackend.dao.user;

import com.example.carwashwebappbackend.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
}
