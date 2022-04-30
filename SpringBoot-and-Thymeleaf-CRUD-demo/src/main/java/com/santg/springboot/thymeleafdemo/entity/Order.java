package com.santg.springboot.thymeleafdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    // define fields
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    @JsonBackReference
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    @JsonBackReference
    private Product product;

    @Column(name="amount")
    private int amount;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name="orderDate")
    private Date orderDate;

    // define cosntructors
    public Order() {
    }

    public Order(int id, Customer customer, Product product, int amount, Date orderDate) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Order(Customer customer, Product product, int amount, Date orderDate) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    // define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
