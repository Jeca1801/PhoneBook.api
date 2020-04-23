
package com.example.demo.repository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.Entities.Contact;
import com.example.demo.Entities.SiteUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
public class DbInit implements CommandLineRunner{

    private UserRepository userRepository;

    private ContactRepository contactRepository;


    public DbInit(UserRepository userRepository, ContactRepository contactRepository){
        this.userRepository = userRepository;
        this.contactRepository =  contactRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        SiteUser kenny = new SiteUser("kenny", "kenny", "kenny123","customer");
        SiteUser johnny = new SiteUser("johnny", "johnny", "johnny123","admin");
        SiteUser vincent = new SiteUser("vincent", "vincent", "vincent123","premium");
        SiteUser a = new SiteUser("a", "a", "a","customer");

        List<SiteUser> users = Arrays.asList(kenny, johnny, vincent, a);

        //sparar alla users i db när programmt körs
        this.userRepository.saveAll(users);

        Contact contact1 = new Contact("Sam", "07323234", "nice guy", new Date());
        Contact contact2 = new Contact("Joe", "07033727", "cool guy", new Date());
        Contact contact3 = new Contact("Sara", "07624282", "boring girl", new Date());

        List<Contact> contacts = Arrays.asList(contact1, contact2, contact3);

        //sparar alla users i db när programmt körs
        this.contactRepository.saveAll(contacts);
    }
}


