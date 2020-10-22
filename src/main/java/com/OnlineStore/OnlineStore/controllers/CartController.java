package com.OnlineStore.OnlineStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.OnlineStore.OnlineStore.models.entity.CartItem;
import com.OnlineStore.OnlineStore.models.entity.CartItemDto;
import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.services.ICartItemService;

import com.OnlineStore.OnlineStore.services.IProductService;

@Controller
public class CartController {
	
	@Autowired
	private ICartItemService cartItemService;
	
	@Autowired
	private IProductService productService;

	@GetMapping("/addtocart")
	public String AddToCart(Model model) {
		
    	model.addAttribute("products", productService.findAll());
    	model.addAttribute("dtoCartItem", new CartItemDto());
        return "addtocart";
    }
	@GetMapping("/cart")
	public String Cart(Model model) {
    	List<CartItem> cart = cartItemService.findAll();
//    	float total = 0.0f;
//    	for (Cart cart: carts) {
//    		total += cart.getQuantity() * cart.getProduct().getPrice();
//    	}
//		model.addAttribute("carts", carts);
//		model.addAttribute("total", total);
    	
        return "cart";
    }
	@PostMapping("/cart")
	public String save(@ModelAttribute("cartItemDto")CartItemDto cartItemDto ) {
		
		Product p = productService.findById(cartItemDto.getProductId());
		CartItem cartItem = new CartItem();
		cartItem.setProduct(p);
		cartItem.setQuantity(cartItemDto.getQuantity());
		cartItemService.save(cartItem);
		return "redirect:/addtocart";}
	}


