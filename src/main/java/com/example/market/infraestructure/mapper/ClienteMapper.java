package com.example.market.infraestructure.mapper;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructure.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "telefono", target ="phoneNumber")
    })
    ClientDTO toClientDTO(Optional<Cliente> cliente);
    List<ClientDTO> toClientsDTO(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toClient(ClientDTO clientDTO);
    List<Cliente> toClients(List<ClientDTO> clientsDTO);
}
