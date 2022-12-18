package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.RoleRepository;
import com.example.carwashwebappbackend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository theRoleRepository) { roleRepository = theRoleRepository;}

    @GetMapping()
    public @ResponseBody Iterable<Role> getRoles() { return roleRepository.findAll(); }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Role addRole(@RequestBody Role role) {
        roleRepository.save(role);
        return role;
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable int id) { return roleRepository.findById(id); }

    @PatchMapping("/{id}")
    public Role updateRole(@PathVariable int id, @RequestBody Role role) {
        Optional<Role> result = roleRepository.findById(id);
        if (result.isPresent()) {
            Role tempRole = result.get();
            tempRole.setName(role.getName());
            roleRepository.save(tempRole);
            return tempRole;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable int id) {
        Optional<Role> result = roleRepository.findById(id);
        if (result.isPresent()) {
            roleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
