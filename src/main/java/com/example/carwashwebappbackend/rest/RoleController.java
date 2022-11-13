package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.role.RoleDaoRepository;
import com.example.carwashwebappbackend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RoleController {
    private RoleDaoRepository roleDaoRepository;

    @Autowired
    public RoleController(RoleDaoRepository theRoleDAO) { roleDaoRepository = theRoleDAO;}

    @GetMapping(path="/roles")
    public @ResponseBody Iterable<Role> getRoles() {
        return roleDaoRepository.findAll();
    }
}
