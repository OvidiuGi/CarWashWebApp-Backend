package com.example.carwashwebappbackend.repository;

import com.example.carwashwebappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
