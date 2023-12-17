package com.example.contact.model;

import com.example.contact.entity.ContactEntity;
import lombok.Data;

@Data
public class ContactModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public static ContactModel toModel(ContactEntity entity){
        ContactModel model = new ContactModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setEmail(entity.getEmail());
        model.setPhoneNumber(entity.getPhoneNumber());
        return model;
    }

    public static ContactEntity toEntity(ContactModel model){
        ContactEntity entity = new ContactEntity();
        ContactEntity.rollBackLastId();
        entity.setId(model.getId());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        entity.setPhoneNumber(model.getPhoneNumber());
        return entity;
    }
}
