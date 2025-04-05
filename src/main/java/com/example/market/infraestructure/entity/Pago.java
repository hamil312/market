package com.example.market.infraestructure.entity;

import jakarta.persistence.*;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fechaPago;
    private double monto;
    private String metodo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ordenid", nullable = false)
    private Orden orden;

    public Pago() {
    }

    public Pago(int fechaPago, double monto, String metodo, String estado, Orden orden) {
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = estado;
        this.orden = orden;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(int fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
