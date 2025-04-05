package com.example.market.domain.dto;

import com.example.market.infraestructure.entity.Orden;

public class PayDTO {
    private Long id;
    private int payDate;
    private double amount;
    private String method;
    private String state;
    private Orden order;

    public PayDTO() {
    }

    public PayDTO(int payDate, double amount, String method, String state, Orden order) {
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

    public int getPayDate() {
        return payDate;
    }

    public void setPayDate(int payDate) {
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

    public Orden getOrder() {
        return order;
    }

    public void setOrder(Orden order) {
        this.order = order;
    }
}
