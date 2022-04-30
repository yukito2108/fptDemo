package com.santg.springboot.thymeleafdemo.service;

import com.santg.springboot.thymeleafdemo.entity.Order;
import com.santg.springboot.thymeleafdemo.entity.Product;

import java.util.List;

public interface OrderService {

	public List<Order> findAll();

	public List<Order> findByCustomerId(int customerId);
	
	public Order findById(int theId);
	
	public void save(Order theOrder);
	
	public void deleteById(int theId);
	
}
