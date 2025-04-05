package com.example.market.domain.repository;

import com.example.market.domain.dto.PayDTO;

import java.util.List;

public interface IPay {
    public List<PayDTO> getAllPayments();
    public PayDTO getPaymentById(Long id);
    public PayDTO savePayment(PayDTO payment);
    public PayDTO updatePayment(PayDTO payment);
    public void deletePayment(Long id);
    public List<PayDTO> getAllPaymentsByOrderId(Long orderId);
}
