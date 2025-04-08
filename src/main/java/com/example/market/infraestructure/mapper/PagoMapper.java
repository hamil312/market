package com.example.market.infraestructure.mapper;

import com.example.market.domain.dto.PayDTO;
import com.example.market.infraestructure.entity.Pago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PagoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fechaPago", target = "payDate"),
            @Mapping(source = "monto", target = "amount"),
            @Mapping(source = "metodo", target = "method"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "orden", target = "order"),
    })
    PayDTO toPayDTO(Pago pago);
    List<PayDTO> toPaymentsDTO(List<Pago> pagos);

    @InheritInverseConfiguration
    Pago toPago(PayDTO payDTO);
    List<Pago> toPayments(List<PayDTO> paymentsDTO);
}
