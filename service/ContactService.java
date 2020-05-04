
package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    //adds a contact
    public void addContact(Contact contact) {
        //sets the created date at "now"
        contact.setCreatedAt(new Date());
        //saves it to the db
        contactRepository.save(contact);
    }
    //method that gets all the contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // method that edits a contact
    public Contact editContact(long contactId, Contact contactToEdit) {
        //loops through all the contacts
        for (Contact c : getAllContacts()) {
            //cheks if the id och the list matches the contactid we put in
            if (c.getId() == contactId) {
                //uppdates the new contact and stores it in the db
                contactRepository.save(contactToEdit);
            }
        }
        return null;
    }

    public Optional<Contact> findContactById(long contactId) {
        return contactRepository.findById(contactId);
    }

    public Contact findContactByName(String name) {
        return contactRepository.findByName(name);
    }

    public void deleteContact(long id) {
        contactRepository.deleteById(id);
    }
}

