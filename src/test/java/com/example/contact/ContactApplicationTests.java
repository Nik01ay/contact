package com.example.contact;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.contact.controller.ContactController;
import com.example.contact.entity.ContactEntity;
import com.example.contact.model.ContactModel;
import com.example.contact.repository.ContactDBRepo;
import com.example.contact.service.ContactService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yml")
@Sql(value = {"/create-contacts-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-contacts-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ContactApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactController contactController;


    @Test
    public void testIndex() throws Exception {

        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(containsString("UrsulaTEST")));
    }

    @Test
    public void testCreate() throws Exception {

        mockMvc.perform(get("/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(content().string(containsString("First Name:")));

    }

    @Test
    public void testEdit() throws Exception {

        mockMvc.perform(get("/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(content().string(containsString("UrsulaTEST")));


    }

    @Test
    public void testaSave() throws Exception {
        ContactModel contactModel = new ContactModel();
        contactModel.setId(1);
        contactModel.setFirstName("NEWJohn");
        contactModel.setLastName("Doe");
        contactModel.setEmail("john.doe@example.com");
        contactModel.setPhoneNumber("123456789");

        mockMvc.perform(post("/save")
                        .flashAttr("contactModel", contactModel))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andDo(print());

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("contacts"))
                .andExpect(model().attribute("contacts", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("firstName", is("NEWJohn")),
                                hasProperty("lastName", is("Doe")),
                                hasProperty("email", is("john.doe@example.com")),
                                hasProperty("phoneNumber", is("123456789"))
                        )
                )));


    }

    @Test
    public void testbDelete() throws Exception {
        mockMvc.perform(get("/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("contacts"))
                .andExpect(model().attribute("contacts", not(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("firstName", is("NEWJohn")),
                                hasProperty("lastName", is("Doe")),
                                hasProperty("email", is("john.doe@example.com")),
                                hasProperty("phoneNumber", is("123456789"))
                        )
                )));


    }


}
