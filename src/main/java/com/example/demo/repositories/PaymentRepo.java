package com.example.demo.repositories;

import com.example.demo.entities.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentRequest, Long> {
}
