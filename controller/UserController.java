package com.example.demo.controller;

import com.example.demo.Entities.SiteUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<SiteUser> getAllUsers(){
        return userRepository.findAll();
    }
}
