package by.jrr.controller;

import by.jrr.bean.User;
import by.jrr.service.UserService;
import by.jrr.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        switch (userValidator.checkUser(userForm)) {
            case "password_valid":{
                model.addAttribute("passwordError", "Пароли больше 2");
                return "registration";
            }
            case "username_valid":{
                model.addAttribute("passwordError", "username больше 2");
                return "registration";
            }
            case "ok" : {
                if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
                    model.addAttribute("passwordError", "Пароли не совпадают");
                    return "registration";
                }
                if (!userService.saveUser(userForm)) {
                    model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
                    return "registration";
                }
                return "redirect:/";
            }
        }
        return "redirect:/";
    }

}
