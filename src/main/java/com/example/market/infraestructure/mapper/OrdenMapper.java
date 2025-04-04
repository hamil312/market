package com.example.market.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructure.entity.Orden;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "fecha", target = "date"),
        @Mapping(source = "total", target = "total"),
        @Mapping(source = "estado", target = "status"),
        @Mapping(source = "cliente", target = "client"),
        @Mapping(source = "ordenItems", target = "orderItems"),
    })
    OrderDTO toOrderDTO(Orden orden);
    List<OrderDTO> toOrdersDTO(List<Orden> ordenes);
    
    @InheritInverseConfiguration
    Orden toOrden(OrderDTO ordenDTO);
    List<Orden> toProducts(List<OrderDTO> ordenesDTO);
}
