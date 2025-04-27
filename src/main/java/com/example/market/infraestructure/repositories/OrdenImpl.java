package com.example.market.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.repository.IOrder;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.mapper.OrdenMapper;

@Repository
public class OrdenImpl implements IOrder {
    @Autowired
    private OrdenRepository OrdenRepository;
    @Autowired
    private OrdenMapper OrdenMapper;

    public List<OrderDTO> getAllOrders() {
        List<Orden> Ordens = OrdenRepository.findAll();
        List<OrderDTO> resultLst= OrdenMapper.toOrdersDTO(Ordens);
        return resultLst;
    }

    public OrderDTO getById(Long id){
        Orden Orden = OrdenRepository.findById(id).get();
        return  OrdenMapper.toOrderDTO(Orden);
    }

    public OrderDTO save(OrderDTO Order) {
        Orden orden = OrdenMapper.toOrden(Order);
        orden.setTotal(0.0);
        return OrdenMapper.toOrderDTO(OrdenRepository.save(orden));
    }

    public void delete(Long id) {
        OrdenRepository.deleteById(id);
    }

    public OrderDTO update(Long id, OrderDTO Order) {
        Orden OrdenToUpdate = OrdenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        Orden updatedOrden = OrdenMapper.toOrden(Order);
        OrdenToUpdate.setFecha(updatedOrden.getFecha());
        OrdenToUpdate.setEstado(updatedOrden.getEstado());
        return OrdenMapper.toOrderDTO(OrdenRepository.save(OrdenToUpdate));
    }

    public List<OrderDTO> getByClientId(Long clientId) {
        List<Orden> Ordenes = OrdenRepository.findAll();
        for(int i = 0; i < Ordenes.size(); i++){
            if(Ordenes.get(i).getCliente().getId() != clientId){
                Ordenes.remove(i);
                i--;
            }
        }
        return OrdenMapper.toOrdersDTO(Ordenes);
    }

    public List<OrderDTO> getByClienteId(Long clienteId) {
        List<Orden> Ordenes = OrdenRepository.findByClienteId(clienteId);
        return OrdenMapper.toOrdersDTO(Ordenes);
    }
}
