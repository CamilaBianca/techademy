package com.amdocs.project.techademy.service.serviceImpl;

import com.amdocs.project.techademy.exception.ResourceNotFoundException;
import com.amdocs.project.techademy.model.Contact;
import com.amdocs.project.techademy.model.User;
import com.amdocs.project.techademy.repository.ContactRepository;
import com.amdocs.project.techademy.repository.UserRepository;
import com.amdocs.project.techademy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(int id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact not found with id " +id));

        return contact;
    }

    @Override
    public Contact updateByWithNewContact(int id, Contact contactDetails) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact not found with id " +id));

        contact.setMessege(contactDetails.getMessege());
        contact.setName(contactDetails.getName());
        contact.setPhoneNo(contactDetails.getPhoneNo());
        contact.setUser(contactDetails.getUser());
        contact.setEmail(contactDetails.getEmail());

        Contact contactUpdate = contactRepository.save(contact);
        return contactUpdate;
    }

    @Override
    public boolean deleteContact(int id) {
        boolean isDeleted = true;

        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact not found with id " +id));

        contactRepository.delete(contact);
        if(contact == null){
            isDeleted = false;
        }
        return isDeleted;
    }
}
