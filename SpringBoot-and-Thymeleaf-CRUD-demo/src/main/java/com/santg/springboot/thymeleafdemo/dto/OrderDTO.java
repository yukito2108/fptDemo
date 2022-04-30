package com.santg.springboot.thymeleafdemo.dto;

public class OrderDTO {
    private int customerId;
    private int productId;
    private int amount;
    private String orderDate;

    public OrderDTO() {
    }

    public OrderDTO(int customerId, int productId, int amount, String orderDate) {
        this.customerId = customerId;
        this.productId = productId;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
