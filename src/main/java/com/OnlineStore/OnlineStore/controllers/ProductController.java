package com.OnlineStore.OnlineStore.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.services.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService productService;
	

   @GetMapping(value = "/product")
	public String listar(Model model) {
		model.addAttribute("products", productService.findAll());
		return "product";
	}
   @GetMapping(value = {"/productform/{Id}"})
   public String edit(Model model, @PathVariable long Id) {

   		Product product = null;
       
	   product = productService.findById(Id); 
    	   
       model.addAttribute("product", product);
       
       return "productform";
   }


   @PostMapping("/productform/{id}")
   public String updateUser(@PathVariable("id") long id, @Valid Product product, 
     BindingResult result, Model model) {
       if (result.hasErrors()) {
    	   product.setId(id);
           return "product";
       }
           
       productService.save(product);
       model.addAttribute("product", productService.findAll());
       return "redirect:/product";
   }
   
	@GetMapping("/productform")
    public String productForm(Model model) {
    	Product product = new Product();    	
    	model.addAttribute("product", product);
        return "productform";
    }
	@PostMapping("/products")
	public String save(@ModelAttribute("productAdd") Product product) {
		productService.save(product);
		return "redirect:/product";
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		productService.findById(id);	     
		productService.delete(id);	
	    return "redirect:/product";
	}
}

