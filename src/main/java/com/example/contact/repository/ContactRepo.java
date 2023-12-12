package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepo {
    public List<ContactEntity> getAll(){
       List<ContactEntity> contacts =  new ArrayList<>();

       ContactEntity contact = new ContactEntity();

       contact.setId(1);
       contact.setFirstName("INVe");
       contact.setLastName("ewwe");
       contact.setEMail("qwe@mew");
       contact.setPhoneNumber("21355");
       contacts.add(contact);

        return contacts;
    }
}
