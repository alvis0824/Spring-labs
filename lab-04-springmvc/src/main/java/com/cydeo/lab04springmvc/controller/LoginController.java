package com.cydeo.lab04springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("login/{email}/{phoneNumber}")
    public String login(@PathVariable String email, @PathVariable String phoneNumber, Model model){

        String loginMessage = "Login successful";

        model.addAttribute("email", email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("loginMessage",loginMessage);

        return "login/login-info";
    }
}
