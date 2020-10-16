package com.OnlineStore.OnlineStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.OnlineStore.OnlineStore.models.entity.Product;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
    @GetMapping("/product")
    public String product(Model model) {
    	Product product = new Product();
    	model.addAttribute("product", product);
        return "product";
    }
}