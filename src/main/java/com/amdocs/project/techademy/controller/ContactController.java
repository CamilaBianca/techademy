package com.amdocs.project.techademy.controller;

import com.amdocs.project.techademy.model.Contact;
import com.amdocs.project.techademy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    // get all contact
    @GetMapping(value = "/contact")
    public ResponseEntity<?> getAllContact(){
        return new ResponseEntity(contactService.getAllContact(), HttpStatus.ACCEPTED);
    }

    // create contact rest api
    @PostMapping("/contact")
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        return new ResponseEntity(contactService.createContact(contact), HttpStatus.CREATED);
    }

    // get contact by id rest api
    @GetMapping("/contact/{id}")
    public ResponseEntity<?> getContactById(@PathVariable int id) {
        return new ResponseEntity(contactService.getContactById(id), HttpStatus.ACCEPTED);
    }

    // update contact rest api
    @PutMapping("/contact/{id}")
    public ResponseEntity<?> updateContact(@PathVariable int id, @RequestBody Contact newContactDetails) {
        return new ResponseEntity(contactService.updateByWithNewContact(id, newContactDetails), HttpStatus.ACCEPTED);
    }

    // delete contact rest api
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable int id){
        return new ResponseEntity(contactService.deleteContact(id), HttpStatus.GONE);
    }
}
