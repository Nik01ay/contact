package com.example.contact.controller;

import com.example.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}