package com.usbbog.SignchatMS.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usbbog.SignchatMS.interfaceServices.IuserService;
import com.usbbog.SignchatMS.interfaces.IUser;
import com.usbbog.SignchatMS.models.User;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private IuserService service;

    @Autowired
    private IUser query;

    @PostMapping("/create")
    public String crearUsuario(Model model, User usuario){
        service.CreateUsuario(usuario);
        return "User created";
    }

    @GetMapping("")
    public List<User> mostrarUsuarios(){
        List<User> usuarios = service.listarUsuarios();
        return usuarios;
    }

    @PostMapping("/login")
    public String LoginUsuario(@RequestParam String nickname, @RequestParam String password){
        System.out.println("Nickname: " + nickname);
        System.out.println("Password: " + password);
        List<User> usuarios = query.findByUserNicknameAndUserPassword(nickname, password);
        for (User usuario : usuarios) {
            System.out.println(usuario);
        }
        return "";
    }
}