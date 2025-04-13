package com.example.market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.repositories.OrdenItemImpl;

@Service
public class OrdenItemService {
    @Autowired
    private OrdenItemImpl ordenItemImpl;

    public List<OrderItemDTO> getAll(Long orderId) {
        return ordenItemImpl.getAllOrderItems(orderId);
    }
    public OrderItemDTO save(Long orderId, OrderItemDTO order) { 
        return ordenItemImpl.saveOrderItem(orderId, order); 
    }
    public void delete(Long orderId, Long orderItemId) { 
        ordenItemImpl.deleteOrderItem(orderId, orderItemId); 
    }
    public OrderItemDTO update(Long orderId, Long orderItemId, OrderItemDTO order) { 
        return ordenItemImpl.updateOrderItem(orderId, orderItemId, order);
    }
}
