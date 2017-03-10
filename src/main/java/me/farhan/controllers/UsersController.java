package me.farhan.controllers;

import me.farhan.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "users")
public class UsersController {

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String showRegistrationFrom(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);

        return "user/register";
    }
}
