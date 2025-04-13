package com.example.market.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.service.OrdenItemService;

@RestController
@RequestMapping("/ordenes")
public class OrdenItemController {
    
    @Autowired
    private OrdenItemService ordenItemService;

    @GetMapping("/{ordenId}/items")
    public List<OrderItemDTO> obtenerOrdenes(@PathVariable Long ordenId) {
        return ordenItemService.getAll(ordenId);
    }

    @PostMapping("/{ordenId}/items")
    public OrderItemDTO guardar(@PathVariable Long ordenId, @RequestBody OrderItemDTO entity) {
        return ordenItemService.save(ordenId, entity);
    }

    @PutMapping("/{ordenId}/items/{id}")
    public OrderItemDTO actualizar(@PathVariable Long ordenId, @PathVariable Long id, @RequestBody OrderItemDTO entity) {
        return ordenItemService.update(ordenId,id, entity);
    }

    @DeleteMapping("/{ordenId}/items/{id}")
    public void eliminar(@PathVariable Long ordenId, @PathVariable Long id) {
        ordenItemService.delete(ordenId, id);
    }
}
