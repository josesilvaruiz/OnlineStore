package com.OnlineStore.OnlineStore.controllers;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.OnlineStore.OnlineStore.models.entity.Client;
import com.OnlineStore.OnlineStore.services.IClienteService;



@Controller
@RequestMapping("/form")
public class RegistrationController {
	
	@Autowired
	private IClienteService clientService;
	

	@RequestMapping(value = "/registration")
	public String formView(Map<String, Object> model) {
		Client client = new Client();
		model.put("client", client);
		return "registrationForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String formPost(@Valid Client client, BindingResult result, Model model, SessionStatus status) {
		clientService.save(client);
		status.setComplete();
		return "redirect:/";
	}
}
