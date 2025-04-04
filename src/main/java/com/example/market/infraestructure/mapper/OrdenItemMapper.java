package com.example.market.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.entity.OrdenItem;

@Mapper(componentModel = "spring")

public interface OrdenItemMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "precioUnitario", target = "unitPrice"),
        @Mapping(source = "producto", target = "productId"),
        @Mapping(source = "orden", target = "orderId"),
    })
    OrderItemDTO toOrderItemDTO(OrdenItem ordenItem);
    List<OrderItemDTO> toOrdersItemsDTO(List<OrdenItem> ordenItems);
    
    @InheritInverseConfiguration
    OrdenItem toOrdenItem(OrderItemDTO ordenItemDTO);
    List<OrdenItem> toProducts(List<OrderItemDTO> ordenItemsDTO);
    
}
