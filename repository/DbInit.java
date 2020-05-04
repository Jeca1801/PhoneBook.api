
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
        // Creating 4 siteusers
        SiteUser kenny = new SiteUser("kenny", "kenny", "kenny123","customer");
        SiteUser johnny = new SiteUser("johnny", "johnny", "johnny123","admin");
        SiteUser vincent = new SiteUser("vincent", "vincent", "vincent123","premium");
        SiteUser a = new SiteUser("a", "a", "a","customer");

        //store them in an siteuser array
        List<SiteUser> users = Arrays.asList(kenny, johnny, vincent, a);

        //saves them to the db when the program is run
        this.userRepository.saveAll(users);

        //creating 3 contacts
        Contact contact1 = new Contact("Sam", "07323234", "nice guy", new Date());
        Contact contact2 = new Contact("Joe", "07033727", "cool guy", new Date());
        Contact contact3 = new Contact("Sara", "07624282", "boring girl", new Date());

        //stores them in a list of contacts
        List<Contact> contacts = Arrays.asList(contact1, contact2, contact3);

        //stores the contacts in the db when the program runs
        this.contactRepository.saveAll(contacts);
    }
}


