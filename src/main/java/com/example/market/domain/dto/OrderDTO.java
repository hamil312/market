package com.example.market.domain.dto;

import java.util.Set;

import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.entity.OrdenItem;

public class OrderDTO {

    private Long id;
    private String date;
    private double total;
    private String status;
    private Cliente client;
    private Set<OrdenItem> orderItems;

    public OrderDTO() {
        
    }

    public OrderDTO(String date, double total, String status, Cliente client) {
        this.date = date;
        this.total = total;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Set<OrdenItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrdenItem> orderItems) {
        this.orderItems = orderItems;
    }

    

}
