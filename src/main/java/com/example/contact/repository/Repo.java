package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;

import java.util.List;

public interface Repo {

    List<ContactEntity> getAll();

    ContactEntity save(ContactEntity contact);

    ContactEntity get(Integer id);

    void deleteById(Integer id);
}

