package com.usbbog.SignchatMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usbbog.SignchatMS.interfaceServices.IcontactlistService;
import com.usbbog.SignchatMS.models.ContactList;

@RestController
@RequestMapping("/api/contacts/")
public class ContactlistController {
    
    @Autowired
    private IcontactlistService service;

    @PostMapping("/create")
    public String crearContacto(Model model, ContactList contacto){
        service.CreateContacto(contacto);
        return "Contact Created";
    }

    @GetMapping("")
    public List<ContactList> mostrarContactos(){
        List<ContactList> contactos = service.listarContactos();
        return contactos;
    }
}
