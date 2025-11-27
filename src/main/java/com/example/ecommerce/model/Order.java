package com.example.ecommerce.model;

import java.util.List;

public class Order {
    private List<Product> items;
    private int totalAmount;
    private String orderId;

    public Order() {
        this.orderId = "ORD-" + System.currentTimeMillis();
    }

    public List<Product> getItems() { return items; }
    public void setItems(List<Product> items) { this.items = items; }

    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

    public String getOrderId() { return orderId; }
}

