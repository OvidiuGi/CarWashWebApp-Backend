package com.example.carwashwebappbackend.service;

import com.example.carwashwebappbackend.model.Role;
import com.example.carwashwebappbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return this.roleRepository.findAll();
    }
}
