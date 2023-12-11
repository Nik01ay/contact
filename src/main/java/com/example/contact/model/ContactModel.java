package com.example.contact.model;

import com.example.contact.entity.ContactEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
