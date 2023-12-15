package com.example.contact.service;

import com.example.contact.model.ContactModel;

import java.util.List;

public interface Serv {
    List<ContactModel> getAll();
    ContactModel get(Integer id);
    void deleteById(Integer id);
    ContactModel save(ContactModel contactModel);
    ContactModel getNewContact();
}
