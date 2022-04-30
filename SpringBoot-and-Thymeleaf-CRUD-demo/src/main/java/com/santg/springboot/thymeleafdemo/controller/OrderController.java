package com.santg.springboot.thymeleafdemo.controller;

import com.santg.springboot.thymeleafdemo.dto.OrderDTO;
import com.santg.springboot.thymeleafdemo.entity.Customer;
import com.santg.springboot.thymeleafdemo.entity.Order;
import com.santg.springboot.thymeleafdemo.entity.Product;
import com.santg.springboot.thymeleafdemo.service.CustomerService;
import com.santg.springboot.thymeleafdemo.service.OrderService;
import com.santg.springboot.thymeleafdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private OrderService orderService;
	private CustomerService customerService;
	private ProductService productService;

	@Autowired
	public OrderController(OrderService orderService, CustomerService customerService, ProductService productService) {
		this.orderService = orderService;
		this.customerService = customerService;
		this.productService = productService;
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String orderList(Model model) {
	
		// get orders from data base
		List<Order> orders = orderService.findAll();
		
		// add to the spring model
		model.addAttribute("orders", orders);
	 
		return "orders/list-orders";
	}


	@GetMapping("/search")
	public String home(Model model, int keyword) {

				List<Order> orders = orderService.findByCustomerId(keyword);
				model.addAttribute("orders", orders);

			return "orders/list-orders";

	}
	
	// add mapping for "/add" to add new orders
	@GetMapping("/add")
	public String addOrder(Model model) {
		List<Customer> customerList = customerService.findAll();
		model.addAttribute("customerList", customerList);
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		OrderDTO orderDTO = new OrderDTO();
		model.addAttribute("order", orderDTO);
		return "orders/order-form";
	}
	
	@GetMapping("/update")
	public String updateOrder(@RequestParam("orderId") int id, Model model) {
		
		// get the order from the service
		Order order = orderService.findById(id);
		
		// set order as a model attribute to pre-populate the form
		model.addAttribute("order", order);
		
		// send over to our form
		return "orders/order-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("orderId") int id) {
		
		// delete order
		orderService.deleteById(id);
		
		// return to list
		return "redirect:/orders/list";
	}
	
	@PostMapping("/save")
	public String saveOrder(@ModelAttribute("order") OrderDTO orderDTO) {
		Customer customer = customerService.findById(orderDTO.getCustomerId());
		Product product = productService.findById(orderDTO.getProductId());
		Date orderDate = null;
		try {
			orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderDTO.getOrderDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Order order = new Order(customer,product,orderDTO.getAmount(),orderDate);
		orderService.save(order);
		
		// use a redirect to prevent duplicated submissions
		return "redirect:/orders/list";
	}
}
