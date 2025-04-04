package com.example.market.domain.dto;

import java.util.Set;

import com.example.market.infraestructure.entity.OrdenItem;

public class ProductDTO {
    
    private Long id;
    private String name;
    private String description;
    private double price;
    private int amount;
    private Set<OrdenItem> orderItems;

    public ProductDTO() {
        
    }

    public ProductDTO(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<OrdenItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrdenItem> ordenItems) {
        this.orderItems = ordenItems;
    }

    
}
