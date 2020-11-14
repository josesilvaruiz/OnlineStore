package com.OnlineStore.OnlineStore.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.OnlineStore.OnlineStore.services.IProductService;
import com.OnlineStore.OnlineStore.services.IUserService;


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