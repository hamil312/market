package com.example.market.domain.service;

import com.example.market.domain.dto.PayDTO;
import com.example.market.infraestructure.entity.Pago;
import com.example.market.infraestructure.repositories.PagoImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService {

    @Autowired
    private PagoImpl pagoImpl;

    public List<PayDTO> getAllPayments() {
        return pagoImpl.getAllPayments();
    }

    public PayDTO getPaymentById(Long id) {
        return pagoImpl.getPaymentById(id);
    }

    public PayDTO savePayment(PayDTO payment) {
        return pagoImpl.savePayment(payment);
    }

    public PayDTO updatePayment(Long id, PayDTO payment) {
        return pagoImpl.updatePayment(id, payment);
    }

    public void deletePayment(Long id) {
        pagoImpl.deletePayment(id);
    }

    public List<PayDTO> getAllPaymentsByOrderId(Long orderId) {
        return pagoImpl.getAllPaymentsByOrderId(orderId);
    }
}
