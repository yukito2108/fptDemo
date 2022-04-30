package com.santg.springboot.thymeleafdemo.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @Column(name="type")
    private String type;

    // define cosntructors
    public Product() {
    }

    public Product(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Product(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // define toString
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
    }
}
