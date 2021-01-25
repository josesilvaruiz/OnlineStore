package com.OnlineStore.OnlineStore.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.services.IProductService;
import com.OnlineStore.OnlineStore.services.IStorageService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IStorageService storageService;

	/*@GetMapping(value = "/product")
	public String getproducts(Model model) {
		model.addAttribute("products", productService.findAll());
		return "product";
	}
*/
	@GetMapping(value = { "/productform/{Id}" })
	public String edit(Model model, @PathVariable long Id) {

		Product product = null;

		product = productService.findById(Id);

		model.addAttribute("product", product);

		return "productform";
	}

	@PostMapping("/productform/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid @ModelAttribute("product") Product product,
			@RequestParam(value = "file", required = false) MultipartFile file, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "productform";
		}
		Product editedProduct = productService.findById(id);
		if (!file.isEmpty()) {

			String uniqueFilename = null;
			try {
				if (editedProduct.getImage() != null) {
					storageService.delete(editedProduct.getImage());
				}
				uniqueFilename = storageService.copy(file);
			} catch (IOException e) {

				e.printStackTrace();

			}
			product.setImage(uniqueFilename);
		} else {

			product.setImage(editedProduct.getImage());
		}
		productService.save(product);
		return "redirect:/product";
	}

	@GetMapping("/productform")
	public String productForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "productform";
	}

	@PostMapping("/addproduct")
	public String save(@Valid @ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file,
			BindingResult bindingResult) {
		String uniqueFilename = null;
		if (bindingResult.hasErrors()) {
			return "productform";
		}
		try {

			uniqueFilename = storageService.copy(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		product.setImage(uniqueFilename);
		productService.save(product);
		return "redirect:/product";

	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		productService.findById(id);
		productService.delete(id);
		return "redirect:/product";
	}
	
	//Pagination
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
    public String listProducts(
      Model model, 
      @RequestParam("page") Optional<Integer> page, 
      @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Product> productPage = productService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("productPage", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "product";
    }
}
