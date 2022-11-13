package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
}
