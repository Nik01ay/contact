package com.example.contact.service;

import com.example.contact.entity.ContactEntity;
import com.example.contact.model.ContactModel;
import com.example.contact.repository.ContactDBRepo;
import com.example.contact.repository.Repo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService  implements Serv {

   private final Repo contactRepo;
    public List<ContactModel> getAll(){
        List<ContactEntity> contactEntities = contactRepo.getAll();
        return contactEntities.stream().map(ContactModel::toModel).collect(Collectors.toList());


    }

    public ContactModel get(Integer id){
        ContactEntity ce = contactRepo.get(id).orElse(new ContactEntity());
       return ContactModel.toModel(ce);
    }

    public void deleteById(Integer id){
        contactRepo.deleteById(id);
    }

    public ContactModel save(ContactModel contactModel) {

        ContactEntity ce =  contactRepo.save(ContactModel.toEntity(contactModel));
        return ContactModel.toModel(ce);
    }

    public ContactModel getNewContact(){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setId(ContactEntity.getLastId());
        return ContactModel.toModel(contactEntity);
    }


}
