package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class PaymentRequest {
    private Long amount; // Use Long for amount
    private String currency;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String paymentMethodId ;

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public PaymentRequest(String paymentMethodId, Long amount, String currency) {
        this.paymentMethodId = paymentMethodId;
        this.amount = amount;
        this.currency = currency;

    }
}
