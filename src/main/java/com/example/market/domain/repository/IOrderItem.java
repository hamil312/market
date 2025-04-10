package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.OrderItemDTO;

public interface IOrderItem {
    List<OrderItemDTO> getAllOrderItems(Long orderId);
    OrderItemDTO saveOrderItem(Long orderId, OrderItemDTO order);
    OrderItemDTO updateOrderItem(Long orderId, Long orderItemId, OrderItemDTO order);
    void deleteOrderItem(Long orderId, Long orderItemId);
}
