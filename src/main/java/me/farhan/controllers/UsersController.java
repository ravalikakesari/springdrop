package me.farhan.controllers;

import me.farhan.dto.UserDto;
import me.farhan.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "users")
public class UsersController {

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String newUser(Model model){

        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "user/register";
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user") @Valid UserDto user,
                                   BindingResult result, WebRequest request, Errors errors){
        User registered = new User();
        if (!result.hasErrors()){

        }

        return null;
    }
}
