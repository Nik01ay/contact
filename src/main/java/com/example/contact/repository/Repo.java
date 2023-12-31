package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;

import java.util.List;
import java.util.Optional;

public interface Repo {

    List<ContactEntity> getAll();

    ContactEntity save(ContactEntity contact);

   Optional <ContactEntity> get(Integer id);

    void deleteById(Integer id);


}

