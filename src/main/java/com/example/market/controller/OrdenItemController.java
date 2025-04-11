package com.example.market.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.service.OrdenItemService;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrdenItemController {
    
    @Autowired
    private OrdenItemService ordenItemService;

    @GetMapping
    public List<OrderItemDTO> obtenerOrdenes(@PathVariable Long orderId) {
        return ordenItemService.getAll(orderId);
    }

    @PostMapping
    public OrderItemDTO guardar(@PathVariable("ordenId") Long orderId, @RequestBody OrderItemDTO entity) {
        return ordenItemService.save(orderId, entity);
    }

    @PutMapping("/{id}")
    public OrderItemDTO actualizar(@PathVariable("ordenId") Long orderId, @PathVariable("id") Long id, @RequestBody OrderItemDTO entity) {
        return ordenItemService.update(orderId,id, entity);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("ordenId") Long orderId, @PathVariable("id") Long id) {
        ordenItemService.delete(orderId, id);
    }
}
