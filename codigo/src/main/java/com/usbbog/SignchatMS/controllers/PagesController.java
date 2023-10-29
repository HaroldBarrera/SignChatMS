package com.usbbog.SignchatMS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/signchat")
    public String Chat(){
        return "chat";
    }
}
