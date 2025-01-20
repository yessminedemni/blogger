package com.example.demo.controllers;

import com.example.demo.entities.PaymentRequest;
import com.example.demo.services.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")public class PaymentController {

    @PostMapping("/create")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            // Assuming you have a PaymentService that handles the payment creation
            PaymentIntent paymentIntent = PaymentService.createPayment(paymentRequest);
            return ResponseEntity.ok("Payment initiated: " + paymentIntent.getId());
        } catch (StripeException e) {
            return ResponseEntity.status(500).body("Payment failed: " + e.getMessage());
        }
    }
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(@RequestBody String clientSecret) {
        try {
            // Retrieve the PaymentIntent using the clientSecret
            PaymentIntent paymentIntent = PaymentIntent.retrieve(clientSecret);

            // If the payment is in a state that requires confirmation, confirm it
            if (paymentIntent.getStatus().equals("requires_confirmation")) {
                paymentIntent.confirm();
            }

            // Return the status of the payment
            return ResponseEntity.ok("Payment confirmed: " + paymentIntent.getStatus());
        } catch (StripeException e) {
            return ResponseEntity.status(500).body("Payment confirmation failed: " + e.getMessage());
        }
    }

}