
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

    public void addContact(Contact contact) {
        contact.setCreatedAt(new Date());
        contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact editContact(long contactId, Contact contactToEdit) {
        for (Contact c : getAllContacts()) {
            if (c.getId() == contactId) {
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

