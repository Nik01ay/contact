package com.example.contact.entity;

import lombok.*;


@ToString
public class ContactEntity {

    private static Integer lastId = 0;
    private Integer id;

    private String firstName;

    private String lastName;

    private String eMail;

    private String phoneNumber;

    public ContactEntity() {
        lastId++;
    }

    public static Integer getLastId() {
        return lastId;
    }

    public static void setLastId(Integer lastId) {
        ContactEntity.lastId = lastId;
    }

    public static void rollBackLastId() {
        lastId--;
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
