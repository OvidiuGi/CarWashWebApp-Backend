package com.example.carwashwebappbackend.rest;

import com.example.carwashwebappbackend.dao.UserRepository;
import com.example.carwashwebappbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {

    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public @ResponseBody Iterable<User> findAll() { return userRepository.findAll(); }

    @PostMapping()
    public User addUser(@RequestBody User user) {
         userRepository.save(user);
         return user;
     }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable int id) { return userRepository.findById(id); }


    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            User tempUser = result.get();
            tempUser.setFirstName(user.getFirstName());
            tempUser.setLastName(user.getLastName());
            tempUser.setEmail(user.getEmail());
            tempUser.setTelephoneNr(user.getTelephoneNr());
            tempUser.setPassword(user.getPassword());
            tempUser.setRole(user.getRole());
            userRepository.save(tempUser);
            return new ResponseEntity<>(tempUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
