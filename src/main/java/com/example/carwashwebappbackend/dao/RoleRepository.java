package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
