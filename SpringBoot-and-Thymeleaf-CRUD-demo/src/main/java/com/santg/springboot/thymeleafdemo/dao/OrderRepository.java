package com.santg.springboot.thymeleafdemo.dao;

import com.santg.springboot.thymeleafdemo.entity.Customer;
import com.santg.springboot.thymeleafdemo.entity.Order;
import com.santg.springboot.thymeleafdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(path="members")
public interface OrderRepository extends JpaRepository<Order, Integer> {

	// add method to sort by Amount
	public List<Order> findAllByOrderByAmountAsc();

	// find all order from a defined customer
	public List<Order> findAllByCustomer(Customer customer);
}
