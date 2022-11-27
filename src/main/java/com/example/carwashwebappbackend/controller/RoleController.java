package com.example.carwashwebappbackend.controller;

import com.example.carwashwebappbackend.model.Role;
import com.example.carwashwebappbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
