package com.OnlineStore.OnlineStore.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.OnlineStore.OnlineStore.models.entity.Cart;
import com.OnlineStore.OnlineStore.models.entity.CartItem;
import com.OnlineStore.OnlineStore.models.entity.CartItemDto;
import com.OnlineStore.OnlineStore.models.entity.Order;
import com.OnlineStore.OnlineStore.models.entity.OrderItem;
import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.models.entity.User;
import com.OnlineStore.OnlineStore.services.ICartService;
import com.OnlineStore.OnlineStore.services.IOrderItemService;
import com.OnlineStore.OnlineStore.services.IOrderService;
import com.OnlineStore.OnlineStore.services.IProductService;
import com.OnlineStore.OnlineStore.services.IUserService;

@Controller
public class CartController {

	@Autowired
	private ICartService cartService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderItemService orderItemService;

	@GetMapping("/addtocart")
	public String AddToCart(Model model, HttpServletRequest request) {

		model.addAttribute("products", productService.findAll());
		model.addAttribute("cartItemDto", new CartItemDto());
		return "addtocart";
	}

// TODO USAR HASHMAP EN VEZ DE LIST
	@GetMapping("/cartview")
	public String Cart(Model model, HttpServletRequest request) {
		try {
			model.addAttribute("cartItem", new CartItem());
			model.addAttribute("cartuser", userService.getAuthUser());
			User user = userService.getAuthUser();
			List<CartItem> cartitems = user.getCart().getCartItem();

			float total = 0.0f;
			for (int i = 0; i < cartitems.size(); i++) {

				total += cartitems.get(i).getQuantity() * cartitems.get(i).getProduct().getPrice();
			}
			model.addAttribute("total", total);
			model.addAttribute("cartitems", cartitems);
			return "cartview";
		} catch (Exception e) {
		    System.out.println ("El error es: " + e.getMessage());
		    e.printStackTrace();
		}
		return null;
		
	}

	@PostMapping("/cartcheckout")
	public String cartcheckout() {
		User user = userService.getAuthUser();
		List<CartItem> cartitems = user.getCart().getCartItem();
		Order order = new Order();
		order.setUser(user);
		float total = 0.0f;
		for (int i = 0; i < cartitems.size(); i++) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartitems.get(i).getProduct());
			orderItem.setQuantity(cartitems.get(i).getQuantity());
			
			total += cartitems.get(i).calculateRow();	
			order.getOrderItem().add(orderItem);
			order.setTotal(total);
		}
		
		
		orderService.save(order);
		cartService.delete(user.getCart().getId());
		return "redirect:/addtocart";

	}

	@PostMapping("/addtocart")
	public String addtocart(@ModelAttribute("cartItemDto") CartItemDto cartItemDto, HttpServletRequest request) {

		Product p = productService.findById(cartItemDto.getProductId());
		CartItem cartItem = new CartItem();
		cartItem.setProduct(p);
		cartItem.setQuantity(cartItemDto.getQuantity());
		User user = userService.getAuthUser();
		if (user.getCart() == null) {
			Cart cart = new Cart();
			cart.setUser(user);
			cart.getCartItem().add(cartItem);
			cartService.save(cart);
		} else {
			Cart cart = user.getCart();
			List<CartItem> cartitems = user.getCart().getCartItem();

			Boolean productExist = false;

			for (int i = 0; i < cartitems.size(); i++) {
				if (cartItem.getProduct().getId() == cartitems.get(i).getProduct().getId()) {

					cartitems.get(i).setQuantity(cartItem.getQuantity() + cartitems.get(i).getQuantity());

					cart.getCartItem().add(cartitems.get(i));

					productExist = true;

					break;
				}
			}
			if (productExist == false) {
				cart.getCartItem().add(cartItem);
			}
			cartService.save(cart);
		}
		return "redirect:/addtocart";
	}
}