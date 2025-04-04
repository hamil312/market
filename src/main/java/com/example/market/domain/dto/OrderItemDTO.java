package com.example.market.domain.dto;

public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double unitPrice;
    private Long productId;
    private Long orderId;

    public OrderItemDTO(int quantity, double unitPrice, Long productId, Long orderId) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
        this.orderId = orderId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
