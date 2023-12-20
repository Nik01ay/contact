package com.example.contact;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.contact.entity.ContactEntity;
import com.example.contact.model.ContactModel;
import com.example.contact.repository.ContactDBRepo;
import com.example.contact.service.ContactService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ContactApplicationTests  {


@Autowired
private MockMvc mockMvc;

@MockBean
private ContactService contactService;


	@Test
	public void testIndex() throws Exception {
		List<ContactModel> contacts = new ArrayList<>();
		contacts.add(ContactModel.toModel(new ContactEntity()));
		when(contactService.getAll()).thenReturn(contacts);

		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"))
				.andExpect(model().attribute("contacts", contacts));
	}

	@Test
	public void testCreate() throws Exception {
		ContactModel contact = new ContactModel();
		when(contactService.getNewContact()).thenReturn(contact);

		mockMvc.perform(get("/create"))
				.andExpect(status().isOk())
				.andExpect(view().name("edit"))
				.andExpect(model().attribute("contact", contact));
	}

	@Test
	public void testEdit() throws Exception {
		ContactModel contact = new ContactModel();
		when(contactService.get(1)).thenReturn(contact);

		mockMvc.perform(get("/edit/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("edit"))
				.andExpect(model().attribute("contact", contact));
	}

	@Test
	public void testSave() throws Exception {
		ContactModel contact = new ContactModel();
		contact.setId(1);
		when(contactService.save(contact)).thenReturn(contact);

		mockMvc.perform(post("/save")
						.param("id", "1")
						.param("firstName", "John")
						.param("lastName", "Doe")
						.param("email", "john.doe@example.com")
						.param("phoneNumber", "123456789"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));

		verify(contactService, times(1)).save(contact);
	}

	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(get("/delete/1"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));

		verify(contactService, times(1)).deleteById(1);
	}





}
