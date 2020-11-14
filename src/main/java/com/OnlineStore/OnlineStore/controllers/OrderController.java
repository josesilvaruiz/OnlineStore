package com.OnlineStore.OnlineStore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.OnlineStore.OnlineStore.models.entity.Order;
import com.OnlineStore.OnlineStore.models.entity.OrderItem;
import com.OnlineStore.OnlineStore.models.entity.User;
import com.OnlineStore.OnlineStore.services.IOrderService;
import com.OnlineStore.OnlineStore.services.IUserService;


@Controller
public class OrderController {
	
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/orders")
	public String ShowOrders(Model model) {
		User user = userService.getAuthUser();
		List<Order> ordersuser = user.getOrder();				
		/*	Iterator<Order> it = ordersuser.iterator();
		while(it.hasNext()) {
			Order order = it.next();
			System.out.println(order.getId());
		}*/

		model.addAttribute("ordersuser", ordersuser);
		return  "orders";
	}
	 @GetMapping(value = {"/orders/{Id}"})
	   public String orderDetails (Model model, @PathVariable long Id) {

		 Order order = new Order();
		 List<OrderItem> orderitems;
		 order = orderService.findById(Id);
		 orderitems = order.getOrderItem();
	       model.addAttribute("order", order);
	       model.addAttribute("orderitems", orderitems);
	       return "orderdetails";
	   }

}
                                                                                                                                         