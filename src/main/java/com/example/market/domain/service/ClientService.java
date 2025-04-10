package com.example.market.domain.service;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructure.repositories.ClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClienteImpl clienteImpl;

    public List<ClientDTO> getAllClients() {
        return clienteImpl.getAllClients();
    }
    public ClientDTO getClientById(Long id) {
        return clienteImpl.getClientById(id);
    }
    public ClientDTO saveClient(ClientDTO clientDTO) {
        return clienteImpl.saveClient(clientDTO);
    }
    public ClientDTO updateClientById(Long id, ClientDTO clientDTO) {
        return clienteImpl.updateClientById(id, clientDTO);
    }
    public void deleteClientById(Long id) {
        clienteImpl.deleteClientById(id);
    }
}
