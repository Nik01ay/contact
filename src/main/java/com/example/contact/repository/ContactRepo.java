package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepo {
   private List<ContactEntity> contacts = new ArrayList<>();

    public ContactRepo(){
        ContactEntity contact = new ContactEntity();
        contact.setId(1);
        contact.setFirstName("INVe");
        contact.setLastName("ewwe");
        contact.setEMail("qwe@mew");
        contact.setPhoneNumber("21355");
        contacts.add(contact);
        ContactEntity contact2 = new ContactEntity();
        contact2.setId(2);
        contact2.setFirstName("INVe");
        contact2.setLastName("ewwe");
        contact2.setEMail("qwe@mew");
        contact2.setPhoneNumber("21355");
        contacts.add(contact2);
    }

    public List<ContactEntity> getAll() {

        return contacts;
    }

    public ContactEntity get(Integer id) {
        return contacts.get(id);
    }

    public void deleteByIndex(Integer index) {
        System.out.println(contacts);
        contacts.remove(index);
        System.out.println("delete - " + index);
        System.out.println(contacts);

    }

    public void save(ContactEntity contactEntity) {

        contacts.add(contactEntity);
    }
}
