package com.example.market.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.entity.OrdenItem;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})

public interface OrdenItemMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "precioUnitario", target = "unitPrice"),
        @Mapping(source = "producto", target = "product"),
        @Mapping(source = "orden", target = "order"),
    })
    OrderItemDTO toOrderItemDTO(OrdenItem ordenItem);
    List<OrderItemDTO> toOrdersItemsDTO(List<OrdenItem> ordenItems);
    
    @InheritInverseConfiguration
    OrdenItem toOrdenItem(OrderItemDTO ordenItemDTO);
    List<OrdenItem> toOrdenItems(List<OrderItemDTO> ordenItemsDTO);
    
}
