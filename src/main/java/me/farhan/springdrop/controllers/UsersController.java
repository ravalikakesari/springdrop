package me.farhan.springdrop.controllers;

import me.farhan.springdrop.domain.dto.UserDto;
import me.farhan.springdrop.domain.entities.User;
import me.farhan.springdrop.exception.EmailExistsException;
import me.farhan.springdrop.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String newUser(Model model){

        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "users/register";
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") @Valid UserDto accountDto,
                                   BindingResult result, WebRequest request, Errors errors){
        User registered = new User();
        if (!result.hasErrors()){
            registered = createUserAccount(accountDto,result);
        }

        if (registered == null){
            result.rejectValue("email", "message.regError");
        }

        if (result.hasErrors()) {
            //model.addAttribute("user",userDto);
            return "users/register";
        }

        return "redirect:/login";
    }

    private User createUserAccount(UserDto userDto,BindingResult bindingResult){
        User registered = null;
        try{
            registered = userService.registerNewUserAccount(userDto);
        }catch (EmailExistsException e){

        }
        return registered;
    }
}
