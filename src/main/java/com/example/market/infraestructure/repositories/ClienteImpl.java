package com.example.market.infraestructure.repositories;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.repository.IClient;
import com.example.market.infraestructure.crud.ClienteRepository;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteImpl implements IClient {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClientDTO> getAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClientsDTO(clientes);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return clienteMapper.toClientDTO(cliente);
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Cliente cliente = clienteMapper.toClient(clientDTO);
        return clienteMapper.toClientDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClientDTO updateClientById(Long id, ClientDTO clientDTO) {
        Cliente cliente =  clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Cliente clienteUpdate = clienteMapper.toClient(clientDTO);
        cliente.setNombre(clienteUpdate.getNombre());
        cliente.setCorreo(clienteUpdate.getCorreo());
        cliente.setDireccion(clienteUpdate.getDireccion());
        cliente.setTelefono(clienteUpdate.getTelefono());
        return clienteMapper.toClientDTO(clienteRepository.save(cliente));
    }

    @Override
    public void deleteClientById(Long id) {
        clienteRepository.deleteById(id);
    }
}
