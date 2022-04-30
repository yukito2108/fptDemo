package com.santg.springboot.thymeleafdemo.service;

import com.santg.springboot.thymeleafdemo.dao.CustomerRepository;
import com.santg.springboot.thymeleafdemo.dao.OrderRepository;
import com.santg.springboot.thymeleafdemo.entity.Customer;
import com.santg.springboot.thymeleafdemo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private CustomerRepository customerRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository theOrderRepository, CustomerRepository theCustomerRepository) {
		orderRepository = theOrderRepository;
		customerRepository = theCustomerRepository;
	}
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAllByOrderByAmountAsc();
	}

	@Override
	public List<Order> findByCustomerId(int customerId) {
		Optional<Customer> result = customerRepository.findById(customerId);
		if(result.isPresent()){
			return orderRepository.findAllByCustomer(result.get());
		}
		return null;
	}

	@Override
	public Order findById(int theId) {
		Optional<Order> result = orderRepository.findById(theId);
		
		Order theOrder = null;
		
		if (result.isPresent()) {
			theOrder = result.get();
		}
		else {
			// we didn't find the order
			throw new RuntimeException("Did not find order id - " + theId);
		}
		
		return theOrder;
	}

	@Override
	public void save(Order theOrder) {
		orderRepository.save(theOrder);
	}

	@Override
	public void deleteById(int theId) {
		orderRepository.deleteById(theId);
	}

}






