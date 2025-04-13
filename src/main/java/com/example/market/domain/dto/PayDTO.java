package com.example.market.domain.dto;


public class PayDTO {
    private Long id;
    private String payDate;
    private double amount;
    private String method;
    private String state;
    private OrderDTO order;

    public PayDTO() {
    }

    public PayDTO(String payDate, double amount, String method, String state, OrderDTO order) {
        this.payDate = payDate;
        this.amount = amount;
        this.method = method;
        this.state = state;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }
}
