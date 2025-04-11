package com.example.market.domain.dto;

import java.util.Set;

public class OrderDTO {

    private Long id;
    private String date;
    private double total;
    private String status;
    private ClientDTO client;
    private Set<OrderItemDTO> orderItems;

    public OrderDTO() {
        
    }

    public OrderDTO(String date, double total, String status, ClientDTO client) {
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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Set<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    

}
