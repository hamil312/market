package com.example.market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructure.repositories.OrdenImpl;

@Service
public class OrdenService {
    
    @Autowired
    private OrdenImpl orderImpl;

    public List<OrderDTO> getAll() {
        return orderImpl.getAllOrders();
    }
    public OrderDTO getById(Long id){ 
        return orderImpl.getById(id); 
    }
    public OrderDTO save(OrderDTO order) { 
        return orderImpl.save(order); 
    }
    public void delete(Long id) { 
        orderImpl.delete(id); 
    }
    public OrderDTO update(Long id, OrderDTO order) { 
        return orderImpl.update(id, order);
    }
    public List<OrderDTO> getByClientId(Long clientId) { 
        return orderImpl.getByClienteId(clientId);
    }
}
