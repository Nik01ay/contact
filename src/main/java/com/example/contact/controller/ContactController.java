package com.example.contact.controller;

import com.example.contact.model.ContactModel;
import com.example.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String index(Model model) {

        try {
            model.addAttribute("contacts", contactService.getAll());
            return "index";
        } catch (Exception e) {
        }
        return "ошибка";
    }

    @GetMapping("/create")
    public String create(Model model) {

        try {
            model.addAttribute("contact",  new ContactModel());
            return "edit";
        } catch (Exception e) {
        }
        return "ошибка";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {

        try {
            model.addAttribute("contact",  contactService.get(id));
            return "edit";
        } catch (Exception e) {
        }
        return "ошибка";
    }


// todo delete and edit

}
