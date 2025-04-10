package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.OrderDTO;

public interface IOrder {
    List<OrderDTO> getAllOrders();
    OrderDTO getById(Long id);
    OrderDTO save(OrderDTO order);
    OrderDTO update(Long id, OrderDTO order);
    void delete(Long id);
}
