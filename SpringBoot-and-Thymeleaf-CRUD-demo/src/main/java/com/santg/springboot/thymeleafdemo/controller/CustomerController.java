package com.santg.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.santg.springboot.thymeleafdemo.entity.Customer;
import com.santg.springboot.thymeleafdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String customerList(Model model) {
	
		// get customers from data base
		List<Customer> customers = customerService.findAll();
		
		// add to the spring model
		model.addAttribute("customers", customers);
	 
		return "customers/list-customers";
	}
	
	// add mapping for "/add" to add new customers
	@GetMapping("/add")
	public String addCustomer(Model model) {
		
		// create model attribute to bind form data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customers/customer-form";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		
		// get the customer from the service
		Customer customer = customerService.findById(id);
		
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		// send over to our form
		return "customers/customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		
		// delete customer
		customerService.deleteById(id);
		
		// return to list
		return "redirect:/customers/list";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		// save the customer
		customerService.save(customer);
		
		// use a redirect to prevent duplicated submissions
		return "redirect:/customers/list";
	}
}
