package com.example.contact.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class ContactEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String phoneNumber;
}
