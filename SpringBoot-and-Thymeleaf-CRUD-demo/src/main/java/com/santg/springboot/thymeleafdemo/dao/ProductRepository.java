package com.santg.springboot.thymeleafdemo.dao;

import com.santg.springboot.thymeleafdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(path="members")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// add method to sort by Price
	public List<Product> findAllByOrderByPriceAsc();
}
