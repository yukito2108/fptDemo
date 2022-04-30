package com.santg.springboot.thymeleafdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santg.springboot.thymeleafdemo.entity.Customer;
import org.springframework.lang.Nullable;

//@RepositoryRestResource(path="members")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// find by ID
	@Nullable
	public Optional<Customer> findById(Integer id);
	// add method to sort by Phone
	public List<Customer> findAllByOrderByPhoneAsc();
}
