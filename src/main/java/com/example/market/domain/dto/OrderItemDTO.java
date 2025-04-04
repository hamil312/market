package com.example.market.domain.dto;

import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.Producto;

public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double unitPrice;
    private Producto product;
    private Orden order;

    public OrderItemDTO(int quantity, double unitPrice, Producto product, Orden order) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product = product;
        this.order = order;
    }

    public OrderItemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Orden getOrder() {
        return order;
    }

    public void setOrder(Orden order) {
        this.order = order;
    }
}
