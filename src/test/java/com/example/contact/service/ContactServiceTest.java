package com.example.contact.service;

import com.example.contact.entity.ContactEntity;
import com.example.contact.model.ContactModel;
import com.example.contact.repository.ContactDBRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)

public class ContactServiceTest {
    @Mock
    private ContactDBRepo contactDBRepo;

    @InjectMocks
    private ContactService contactService;


    private List<ContactEntity> createContacts() {
        List<ContactEntity> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ContactEntity contact = new ContactEntity();
            contact.setId(i + 1);
            contact.setFirstName("FirstName-" + i);
            contact.setLastName("LastName-" + i);
            contact.setEmail("email-" + i);
            contact.setPhoneNumber("+" + Integer.toString(i).repeat(9));
            result.add(contact);
        }

        return result;
    }

    @Test
    void getAll() {
        Mockito.when(contactDBRepo.getAll()).thenReturn(createContacts());
        List<ContactModel> result = contactService.getAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void get() {
        Mockito.when(contactDBRepo.get(1)).thenReturn(Optional.ofNullable(createContacts().get(0)));
        ContactModel result = contactService.get(1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("FirstName-0", result.getFirstName());
        Assertions.assertEquals("LastName-0", result.getLastName());
        Assertions.assertEquals("email-0", result.getEmail());
        Assertions.assertEquals("+000000000", result.getPhoneNumber());
    }

    @Test
    void deleteById() {
        contactService.deleteById(0);
        Mockito.verify(contactDBRepo,
                        Mockito.times(1))
                .deleteById(Mockito.any(Integer.class));

    }

    @Test
    void save() {

        Mockito.when(contactDBRepo.save(Mockito.any(ContactEntity.class))).thenReturn(createContacts().get(1));
        ContactModel result = contactService.save(ContactModel.toModel(createContacts().get(1)));
        Assertions.assertNotNull(result);
        Assertions.assertEquals("FirstName-1", result.getFirstName());
    }

    @Test
    void getNewContact() {
        Assertions.assertNotNull(contactService.getNewContact());
    }

}