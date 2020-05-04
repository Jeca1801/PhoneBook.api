package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.SiteUser;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepositoy;

    //finds user by id
    public Optional<SiteUser> findUserById(long id) {
        return userRepository.findById(id);
    }

    //gets all the users
    public List<SiteUser> getAllusers() {
        return userRepository.findAll();
    }
}
