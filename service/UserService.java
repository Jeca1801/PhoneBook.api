package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.Contact;
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

    public Optional<SiteUser> findUserById(long id) {
        return userRepository.findById(id);
    }

    public List<SiteUser> getAllusers() {
        return userRepository.findAll();
    }

    public SiteUser findCustomerByUsername(String username) {
        return userRepository.findByUsername(username);
    }
/*
    @Override
    public String cryptPassword(String password) {
        String algorithm = "SHA";

        byte[] plainText = password.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e); //TODO something?
        }
        return null;
    }
    */

    public void createUser(SiteUser user) {
        userRepository.save(user);
    }

    public List<Contact> findContactsForUser(String name){
        List<SiteUser> userList = getAllusers();
        for(SiteUser u : userList){
            if(u.getName().equalsIgnoreCase(name)){
                return contactRepositoy.findAll();
            }
        }
        return null;
    }
}
