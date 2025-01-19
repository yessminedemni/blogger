package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Change to Long for ID
    private String name;
    private String description;
    private Long amount; // Change to Long for amount
    private String currency;
    private String message;
    private Boolean success;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public PaymentResponse(String name, String description, Long amount, String currency, String message, Boolean success) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.message = message;
        this.success = success;


    }
    @OneToOne
    @JoinColumn(name = "payment_request_id")
    private PaymentRequest paymentRequest;
}