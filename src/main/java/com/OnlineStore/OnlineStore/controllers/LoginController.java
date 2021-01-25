package com.OnlineStore.OnlineStore.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login(Principal principal) {
    	if (principal != null) {
    		return "redirect:/";
        }
    		return "login";
    }
}