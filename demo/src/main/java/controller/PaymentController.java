package controller;

import java.util.List;

import dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.PaymentRequest;
import service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> pay(@RequestBody PaymentRequest dto ){
        return ResponseEntity.ok(paymentService.makePayment(dto));
    }
    @GetMapping
    public ResponseEntity<List<PaymentResponse>>getAll(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}
