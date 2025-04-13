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
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "orden")
    private Set<OrdenItem> ordenItems;
    @OneToMany(mappedBy = "orden")
    private Set<Pago> pagos;

    public Orden() {

    }
    
    public Orden(String fecha, double total, String estado, Cliente cliente) {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
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
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<OrdenItem> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(Set<OrdenItem> ordenItems) {
        this.ordenItems = ordenItems;
    }

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }
}
