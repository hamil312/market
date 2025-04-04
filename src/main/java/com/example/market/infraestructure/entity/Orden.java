package com.example.market.infraestructure.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "ordenes")
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private double total;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Long idCliente;
    @OneToMany(mappedBy = "ordenes")
    private Set<OrdenItem> ordenItems;

    public Orden() {

    }
    
    public Orden(String fecha, double total, String estado, Long idCliente) {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Set<OrdenItem> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(Set<OrdenItem> ordenItems) {
        this.ordenItems = ordenItems;
    }

    

}
