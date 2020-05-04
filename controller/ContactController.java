package com.example.demo.controller;

import com.example.demo.Entities.Contact;
import com.example.demo.service.ContactService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Optional<Contact> findContactById(@PathVariable long id){
        return contactService.findContactById(id);
    }
    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    //calls the contact service which adds the contact to the db
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }
    // Todo the edit method
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public void addContact(@RequestBody Contact contactToEdit,  @PathVariable long id){
        //calls the contactservice which edits the contact, checks matching id and adds the new contact
        contactService.editContact(id, contactToEdit);
    }
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    // checks the matching id and deletes the contact
    public void deleteContact(@PathVariable long id){
        contactService.deleteContact(id);
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    //searches for the contact by name and returns it as an object
    public Contact searchForContact(@PathVariable String name){
        return contactService.findContactByName(name);
    }
}
