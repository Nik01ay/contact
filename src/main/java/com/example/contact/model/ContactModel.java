package com.example.contact.model;

import com.example.contact.entity.ContactEntity;



public class ContactModel {

    private Integer id;

    private String firstName;

    private String lastName;

    private String eMail;

    private String phoneNumber;

    public static ContactModel toModel(ContactEntity entity){
        ContactModel model = new ContactModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setEMail(entity.getEMail());
        model.setPhoneNumber(entity.getPhoneNumber());
        return model;
    }
    public static ContactEntity toEntity(ContactModel model){
        ContactEntity entity = new ContactEntity();
        ContactEntity.rollBackLastId();
        entity.setId(model.getId());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEMail(model.getEMail());
        entity.setPhoneNumber(model.getPhoneNumber());
        return entity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
