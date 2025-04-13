package com.example.market.controller;

import com.example.market.domain.dto.PayDTO;
import com.example.market.domain.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    PayService payService;

    @GetMapping
    public List<PayDTO> getAllPayments(){
        return payService.getAllPayments();
    }

    @GetMapping("/{id}")
    public  PayDTO getPaymentById(@PathVariable long id){
        return payService.getPaymentById(id);
    }

    @PostMapping
    public PayDTO createPayment(@RequestBody PayDTO payDTO){
        return payService.savePayment(payDTO);
    }

    @PutMapping("/{id}")
    public PayDTO updatePayment(@PathVariable long id, @RequestBody PayDTO payDTO){
        return payService.updatePayment(id, payDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentById(@PathVariable long id){
        payService.deletePayment(id);
    }

    @GetMapping("/orden/{orderId}")
    public List<PayDTO> getAllPaymentsByOrderId(@PathVariable Long orderId) {
        return payService.getAllPaymentsByOrderId(orderId);
    }
}
