package com.example.market.infraestructure.crud;

import com.example.market.infraestructure.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> getPagosByOrdenId(Long orderId);
}
