package com.OnlineStore.OnlineStore.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.OnlineStore.OnlineStore.models.entity.Cart;
import com.OnlineStore.OnlineStore.models.entity.CartItem;
import com.OnlineStore.OnlineStore.models.entity.CartItemDto;
import com.OnlineStore.OnlineStore.models.entity.Order;
import com.OnlineStore.OnlineStore.models.entity.OrderItem;
import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.models.entity.User;
import com.OnlineStore.OnlineStore.services.ICartService;
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

	@GetMapping("/")
	public String addtocart(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(4);
		Page<Product> productPage = productService.findAll(PageRequest.of(currentPage - 1, pageSize));

		int totalPages = productPage.getTotalPages();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("productPage", productPage);
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("cartItemDto", new CartItemDto());
		return "home";
	}

// TODO USAR HASHMAP EN VEZ DE LIST
	@GetMapping("/cartview")
	public String Cart(Model model) {

		User user = userService.getAuthUser();
		if (userService.getAuthUser().getCart() != null) {
			List<CartItem> cartitems = user.getCart().getCartItem();
			float total = 0.0f;
			for (int i = 0; i < cartitems.size(); i++) {
				total += cartitems.get(i).getQuantity() * cartitems.get(i).getProduct().getPrice();
			}
			model.addAttribute("total", total);
			model.addAttribute("cartitems", cartitems);
		}
		return "cartview";

	}

	@PostMapping("/cartcheckout")
	public String cartcheckout(@ModelAttribute("cartItemDto") CartItemDto cartItemDto, Order order,
			RedirectAttributes redirectAttrs) {

		User user = userService.getAuthUser();
		List<CartItem> cartitems = user.getCart().getCartItem();
		order.setUser(user);
		float total = 0.0f;
		Boolean overstock = false;

		List<Product> overstockitems = new ArrayList<Product>();
		for (int i = 0; i < cartitems.size(); i++) {
			OrderItem orderItem = new OrderItem();
			Product p = cartitems.get(i).getProduct();

			if (cartItemDto.getQuantity() > p.getStock()) {
				overstock = true;
				overstockitems.add(p);

			}
			if (!overstock) {
				orderItem.setProduct(cartitems.get(i).getProduct());
				orderItem.setQuantity(cartItemDto.getQuantity());
				p.setStock(p.getStock() - cartItemDto.getQuantity());

				total += cartitems.get(i).calculateRow();
				order.setTotal(total);
				order.getOrderItem().add(orderItem);

			}

		}
		if (overstock) {

			redirectAttrs.addFlashAttribute("message", overstockitems);
			return "redirect:/cartview";
		}
		orderService.save(order);
		cartService.delete(user.getCart().getId());

		return "redirect:/orders";

	}

	@PostMapping("emptycart")
	public String emptycart() {
		User user = userService.getAuthUser();
		cartService.delete(user.getCart().getId());
		return "redirect:/cartview";
	}

	@PostMapping("/addtocart")
	public String addtocart(@ModelAttribute("cartItemDto") CartItemDto cartItemDto, HttpServletRequest request,
			BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			return "redirect:/home";
		}
		Product p = productService.findById(cartItemDto.getProductId());
		CartItem cartItem = new CartItem();
		cartItem.setProduct(p);
		Boolean overstock = false;
		if (cartItemDto.getQuantity() > p.getStock()) {
			overstock = true;
			
			redirectAttrs.addFlashAttribute("message", p);
			return "redirect:/";

		}
		if (!overstock) {
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
				if (!productExist) {
					cart.getCartItem().add(cartItem);
				}
				cartService.save(cart);
			}
		}
		return "redirect:/?success";
	}
}