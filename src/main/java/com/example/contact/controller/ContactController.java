package com.example.contact.controller;

import com.example.contact.model.ContactModel;
import com.example.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save/{id}")
    public String edit(@PathVariable("id") Integer id, ContactModel contactModel) {

        try {
            contactService.save(contactModel);

            return "redirect:/";
        } catch (Exception e) {
        }
        return "ошибка";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        try {
            contactService.deleteById(id);

            return "redirect:/";
            //return ResponseEntity.ok(200);

        } catch (Exception e) {
            //return ResponseEntity.badRequest().body("произошла ошибка");
            return "ошибка";
        }
    }

// todo delete and edit

}
