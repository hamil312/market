package com.example.market.domain.repository;

import com.example.market.domain.dto.ClientDTO;

import java.util.List;

public interface IClient {
    public List<ClientDTO> getAllClients();
    public ClientDTO getClientById(Long id);
    public ClientDTO saveClient(ClientDTO clientDTO);
    public ClientDTO updateClientById(Long id, ClientDTO clientDTO);
    public void deleteClientById(Long id);
}
