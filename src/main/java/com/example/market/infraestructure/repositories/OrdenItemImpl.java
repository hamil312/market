package com.example.market.infraestructure.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        Set<OrdenItem> ordenItems = orden.getOrdenItems();
        List<OrdenItem> orderItems = new ArrayList<OrdenItem>(ordenItems);
        return ordenItemMapper.toOrdersItemsDTO(orderItems);
    }

    public OrderItemDTO saveOrderItem(Long id, OrderItemDTO orderItemDTO) {
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        Producto producto = productoRepository.findById(orderItemDTO.getProduct().getId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        OrdenItem ordenItem = ordenItemMapper.toOrdenItem(orderItemDTO);
        double total = orden.getTotal();
        ordenItem.setOrden(orden);
        ordenItem.setProducto(producto);
        ordenItem.setPrecioUnitario(producto.getPrecio());
        total += ordenItem.getPrecioUnitario() * ordenItem.getCantidad();
        orden.setTotal(total);
        ordenRepository.save(orden);
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(ordenItem));
    }

    public void deleteOrderItem(Long id, Long orderItemId) {
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        OrdenItem ordenItem = ordenItemRepository.findById(orderItemId).orElseThrow(() -> new RuntimeException("Orden Item no encontrado"));
        double total = orden.getTotal();
        if (!ordenItem.getOrden().getId().equals(orden.getId())) {
            throw new RuntimeException("El orden item no pertenece a la orden especificada");
        }
        total -= ordenItem.getPrecioUnitario() * ordenItem.getCantidad();
        orden.setTotal(total);
        ordenRepository.save(orden);
        ordenItemRepository.deleteById(orderItemId);
    }

    public OrderItemDTO updateOrderItem(Long id, Long orderItemId, OrderItemDTO orderItemdto) {
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        OrdenItem ordenItemToUpdate = ordenItemRepository.findById(orderItemId).orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        OrdenItem updatedOrdenItem = ordenItemMapper.toOrdenItem(orderItemdto);
        Producto producto = productoRepository.findById(updatedOrdenItem.getProducto().getId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        double total = orden.getTotal();
        if (!ordenItemToUpdate.getOrden().getId().equals(orden.getId())) {
            throw new RuntimeException("El orden item no pertenece a la orden especificada");
        }
        total -= ordenItemToUpdate.getPrecioUnitario() * ordenItemToUpdate.getCantidad();
        ordenItemToUpdate.setCantidad(updatedOrdenItem.getCantidad());
        ordenItemToUpdate.setPrecioUnitario(producto.getPrecio());
        ordenItemToUpdate.setProducto(updatedOrdenItem.getProducto());
        ordenItemToUpdate.setOrden(orden);
        total += ordenItemToUpdate.getPrecioUnitario() * ordenItemToUpdate.getCantidad();
        orden.setTotal(total);
        ordenRepository.save(orden);
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(ordenItemToUpdate));
    }
}
