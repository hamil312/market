package com.example.market.infraestructure.repositories;

import com.example.market.domain.dto.PayDTO;
import com.example.market.domain.repository.IPay;
import com.example.market.infraestructure.crud.PagoRepository;
import com.example.market.infraestructure.entity.Pago;
import com.example.market.infraestructure.mapper.PagoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagoImpl implements IPay {

    @Autowired
    private PagoRepository  pagoRepository;
    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public List<PayDTO> getAllPayments() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagoMapper.toPaymentsDTO(pagos);
    }

    @Override
    public PayDTO getPaymentById(Long id) {
        Pago pago = pagoRepository.findById(id).get();
        return pagoMapper.toPayDTO(pago);
    }

    @Override
    public PayDTO savePayment(PayDTO payment) {
        Pago pago = pagoMapper.toPago(payment);
        return pagoMapper.toPayDTO(pagoRepository.save(pago));
    }

    @Override
    public PayDTO updatePayment(Long id, PayDTO payment) {
        Pago pago = pagoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No existe el pago con el id: " + id));
        Pago pagoUpdate = pagoMapper.toPago(payment);
        pago.setFechaPago(pagoUpdate.getFechaPago());
        pago.setMonto(pagoUpdate.getMonto());
        pago.setMetodo(pagoUpdate.getMetodo());
        pago.setEstado(pagoUpdate.getEstado());
        return pagoMapper.toPayDTO(pagoRepository.save(pago));
    }

    @Override
    public void deletePayment(Long id) {
        pagoRepository.deleteById(id);
    }

    @Override
    public List<PayDTO> getAllPaymentsByOrderId(Long orderId) {
        List<Pago> pagos = pagoRepository.getPagosByOrdenId(orderId);
        return pagoMapper.toPaymentsDTO(pagos);
    }
}
