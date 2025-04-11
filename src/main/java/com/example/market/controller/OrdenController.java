package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.service.OrdenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<OrderDTO> obtenerOrdenes() {
        return ordenService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDTO obtenerOrden(@PathVariable Long id){
        return ordenService.getById(id);
    }

    @PostMapping
    public OrderDTO guardar(@RequestBody OrderDTO entity) {
        return ordenService.save(entity);
    }

    @PutMapping("/{id}")
    public OrderDTO actualizar(@PathVariable Long id, @RequestBody OrderDTO entity) {
        return ordenService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        ordenService.delete(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<OrderDTO> obtenerOrdenesPorCliente(@PathVariable Long idCliente) {
        return ordenService.getByClientId(idCliente);
    }

}
