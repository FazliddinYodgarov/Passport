package com.company.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String goToHome() {
        return "loginPage";
    }

    @RequestMapping("/go_to_login")
    public String goToLogin() {
        return "loginPage";
    }
}
