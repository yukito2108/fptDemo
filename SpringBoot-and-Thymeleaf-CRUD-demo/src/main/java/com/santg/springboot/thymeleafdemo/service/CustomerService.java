package com.santg.springboot.thymeleafdemo.service;

import java.util.List;

import com.santg.springboot.thymeleafdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
}
