package com.OnlineStore.OnlineStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.OnlineStore.OnlineStore.models.entity.Cart;
import com.OnlineStore.OnlineStore.models.entity.CartItem;
import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.services.ICartService;
import com.OnlineStore.OnlineStore.services.IProductService;

@Controller
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IProductService productService;

	@GetMapping("/addtocart")
	public String AddToCart(Model model) {
    	model.addAttribute("products", productService.findAll());
    	model.addAttribute("cartItem", new CartItem());
        return "addtocart";
    }
	@GetMapping("/cart")
	public String Cart(Model model) {
    	List<Cart> carts = cartService.findAll();
    	Double total = 0.0;
    	for (Cart cart: carts) {
    		total += cart.getQuantity() * cart.getProduct().getPrice();
    	}
		model.addAttribute("carts", carts);
		model.addAttribute("total", total);
    	
        return "cart";
    }
	@PostMapping("/cart")
	public String save(@ModelAttribute("cartItem")CartItem cartItem) {
		Product p = productService.findById(cartItem.getProductId());	
		Cart c = new Cart();
		c.setQuantity(cartItem.getQuantity());
		c.setProduct(p);
		cartService.save(c);
		return "redirect:/addtocart";}
	}

