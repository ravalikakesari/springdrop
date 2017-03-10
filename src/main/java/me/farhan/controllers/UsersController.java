package me.farhan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UsersController {

    @RequestMapping(path = "/register")
    public String register(Model model){
        return "user/register";
    }
}
