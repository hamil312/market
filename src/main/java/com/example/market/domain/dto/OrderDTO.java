package com.example.market.domain.dto;

import java.util.Set;

import com.example.market.infraestructure.entity.OrdenItem;

public class OrderDTO {

    private Long id;
    private String date;
    private double total;
    private String status;
    private Long idClient;
    private Set<OrdenItem> orderItems;

    public OrderDTO() {
        
    }

    public OrderDTO(String date, double total, String status, Long idClient) {
        this.date = date;
        this.total = total;
        this.status = status;
        this.idClient = idClient;
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

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Set<OrdenItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrdenItem> orderItems) {
        this.orderItems = orderItems;
    }

    

}
