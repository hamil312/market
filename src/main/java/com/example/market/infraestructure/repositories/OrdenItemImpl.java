package com.example.market.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.infraestructure.crud.OrdenItemRepository;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.crud.ProductoRepository;
import com.example.market.infraestructure.entity.OrdenItem;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.mapper.OrdenItemMapper;

@Repository
public class OrdenItemImpl implements IOrderItem {
    
    @Autowired
    private OrdenItemRepository ordenItemRepository;
    @Autowired
    private OrdenItemMapper ordenItemMapper;
    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public List<OrderItemDTO> getAllOrderItems(Long id) {
        List<OrdenItem> orderItems = ordenItemRepository.findByOrdenId(id);
        return ordenItemMapper.toOrdersItemsDTO(orderItems);
    }

    public OrderItemDTO saveOrderItem(Long id, OrderItemDTO orderItemDTO) {
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        Producto producto = productoRepository.findById(orderItemDTO.getProduct().getId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        OrdenItem ordenItem = ordenItemMapper.toOrdenItem(orderItemDTO);
        ordenItem.setOrden(orden);
        ordenItem.setProducto(producto);
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(ordenItem));
    }

    public void deleteOrderItem(Long id, Long orderItemId) {
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        OrdenItem ordenItem = ordenItemRepository.findById(orderItemId).orElseThrow(() -> new RuntimeException("Orden Item no encontrado"));
        if (!ordenItem.getOrden().getId().equals(orden.getId())) {
            throw new RuntimeException("El orden item no pertenece a la orden especificada");
        }
        ordenItemRepository.deleteById(id);
    }

    public OrderItemDTO updateOrderItem(Long id, Long orderItemId, OrderItemDTO orderItemdto) {
        OrdenItem ordenItemToUpdate = ordenItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        OrdenItem updatedOrdenItem = ordenItemMapper.toOrdenItem(orderItemdto);
        ordenItemToUpdate.setCantidad(updatedOrdenItem.getCantidad());
        ordenItemToUpdate.setPrecioUnitario(updatedOrdenItem.getPrecioUnitario());
        ordenItemToUpdate.setProducto(updatedOrdenItem.getProducto());
        ordenItemToUpdate.setOrden(updatedOrdenItem.getOrden());
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(ordenItemToUpdate));
    }
}
