package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
}
