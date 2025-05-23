package com.example.market.controller;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable long id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO){
        return clientService.saveClient(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO){
        return clientService.updateClientById(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable long id){
        clientService.deleteClientById(id);
    }
}
