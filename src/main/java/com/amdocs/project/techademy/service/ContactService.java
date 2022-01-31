package com.amdocs.project.techademy.service;

import com.amdocs.project.techademy.model.Contact;
import com.amdocs.project.techademy.model.User;

import java.util.List;

public interface ContactService {

    /**
     * @return list of all contact
     */
    List<Contact> getAllContact();

    /**
     * @param id
     * @return true if contact with input id is deleted
     */
    boolean deleteContact(int id);

    /**
     * @param id
     * @param contact
     * @return
     */
    Contact updateByWithNewContact(int id, Contact contact);

    /**
     * @param id
     * @return
     */
    Contact getContactById(int id);

    /**
     * @param contact
     * @return
     */
    Contact createContact(Contact contact);
}
