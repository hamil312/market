package com.example.market.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructure.entity.Cliente;

@Mapper(componentModel = "spring", uses = {OrdenMapper.class})
public interface ClienteMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "correo", target = "email"),
        @Mapping(source = "direccion", target = "address"),
        @Mapping(source = "telefono", target ="phoneNumber"),
        @Mapping(source = "ordenes", target = "orders")
    })
    ClientDTO toClientDTO(Cliente cliente);
    List<ClientDTO> toClientsDTO(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toClient(ClientDTO clientDTO);
    List<Cliente> toClients(List<ClientDTO> clientsDTO);
}
