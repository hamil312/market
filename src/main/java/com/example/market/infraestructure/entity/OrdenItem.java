package com.example.market.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orden_items")
public class OrdenItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precioUnitario;
    @ManyToOne
    @JoinColumn(name = "productoid", nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "ordenid", nullable = false)
    private Orden orden;
    
    public OrdenItem(int cantidad, double precioUnitario, Producto producto, Orden orden) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
        this.orden = orden;
    }

    public OrdenItem() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Orden getOrden() {
        return orden;
    }
    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    
}
