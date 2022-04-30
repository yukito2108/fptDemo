package com.santg.springboot.thymeleafdemo.controller;

import com.santg.springboot.thymeleafdemo.entity.Product;
import com.santg.springboot.thymeleafdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String productList(Model model) {
	
		// get products from data base
		List<Product> products = productService.findAll();
		
		// add to the spring model
		model.addAttribute("products", products);
	 
		return "products/list-products";
	}
	
	// add mapping for "/add" to add new products
	@GetMapping("/add")
	public String addProduct(Model model) {
		
		// create model attribute to bind form data
		Product product = new Product();
		
		model.addAttribute("product", product);
		
		return "products/product-form";
	}
	
	@GetMapping("/update")
	public String updateProduct(@RequestParam("productId") int id, Model model) {
		
		// get the product from the service
		Product product = productService.findById(id);
		
		// set product as a model attribute to pre-populate the form
		model.addAttribute("product", product);
		
		// send over to our form
		return "products/product-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int id) {
		
		// delete product
		productService.deleteById(id);
		
		// return to list
		return "redirect:/products/list";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		// save the product
		productService.save(product);
		
		// use a redirect to prevent duplicated submissions
		return "redirect:/products/list";
	}
}
