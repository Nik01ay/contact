package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactHashMapRepo implements Repo {
   private HashMap<Integer, ContactEntity> contacts = new HashMap<>();

    public ContactHashMapRepo(){
        ContactEntity contact = new ContactEntity();
        contact.setId(1);
        contact.setFirstName("INVe");
        contact.setLastName("ewwe");
        contact.setEmail("qwe@mew");
        contact.setPhoneNumber("21355");
        contacts.put(contact.getId(), contact);
        ContactEntity contact2 = new ContactEntity();
        contact2.setId(2);
        contact2.setFirstName("INVe");
        contact2.setLastName("ewwe");
        contact2.setEmail("qwe@mew");
        contact2.setPhoneNumber("21355");
        contacts.put(contact2.getId(), contact2);
    }

    public List<ContactEntity> getAll() {

        return contacts.values().stream().toList();
    }

    public Optional<ContactEntity> get(Integer id) {
        return   Optional.ofNullable(contacts.get(id));
    }

    public void deleteById(Integer id) {
        System.out.println(contacts);
        contacts.remove(id);
        System.out.println("delete - " + id);
        System.out.println(contacts);

    }

    public ContactEntity save(ContactEntity contactEntity) {
        contacts.put(contactEntity.getId(), contactEntity);
        return  contactEntity;
    }
}
