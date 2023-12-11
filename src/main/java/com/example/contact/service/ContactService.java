package com.example.contact.service;

import com.example.contact.entity.ContactEntity;
import com.example.contact.model.ContactModel;
import com.example.contact.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;
    public List<ContactModel> getAll(){

        List<ContactEntity> contactEntities = contactRepo.getAll();

        return contactEntities.stream().map(ContactModel::toModel).collect(Collectors.toList());


    }
}
