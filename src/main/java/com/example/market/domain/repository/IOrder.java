package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.OrderDTO;

public interface IOrder {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    void saveOrder(OrderDTO order);
    void updateOrder(OrderDTO order);
    void deleteOrder(Long id);
}
