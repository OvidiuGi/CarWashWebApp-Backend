package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.RoleRepository;
import com.example.carwashwebappbackend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {
    private RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository theRoleRepository) { roleRepository = theRoleRepository;}

    @GetMapping()
    public @ResponseBody Iterable<Role> getRoles() { return roleRepository.findAll(); }
}
