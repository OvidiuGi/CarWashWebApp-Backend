package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.RoleRepository;
import com.example.carwashwebappbackend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController {
    private RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository theRoleRepository) { roleRepository = theRoleRepository;}

    @GetMapping()
    public @ResponseBody Iterable<Role> getRoles() { return roleRepository.findAll(); }
}
