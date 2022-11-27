package com.example.carwashwebappbackend.repository;

import com.example.carwashwebappbackend.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
