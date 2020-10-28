package com.OnlineStore.OnlineStore.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.OnlineStore.OnlineStore.services.IProductService;




@Controller
public class MainController {
	
	@Autowired
	private IProductService productService;
	
    @GetMapping("/")
    public String Home(Model model) {
    	model.addAttribute("products", productService.findAll());
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
}