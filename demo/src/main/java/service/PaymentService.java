package service;

import java.util.List;
import java.util.stream.Collectors;

import dto.PaymentRequest;
import dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import entity.Payment;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse makePayment(PaymentRequest request) {
        Payment pay = new Payment();
        pay.setUserId(request.userId);
        pay.setPlanId(request.planId);
        pay.setAmount(request.amount);
        pay.setCurrency(request.currency);
        pay.setPaymentType(request.paymentType);
        pay.setPaymentStatus(request.paymentStatus);
        pay.setPaymentDate(request.paymentDate);
        pay.setTransactionId(request.transactionId);

        Payment saved= paymentRepository.save(pay);
        PaymentResponse response= new PaymentResponse();
        response.id = saved.getId();
        response.userId = saved.getUserId();
        response.planId = saved.getPlanId();
        response.amount = saved.getAmount();
        response.currency = saved.getCurrency();
        response.paymentType = saved.getPaymentType();
        response.paymentStatus = saved.getPaymentStatus();
        response.paymentDate = saved.getPaymentDate();
        response.transactionId = saved.getTransactionId();

        return response;
    }

    public List<PaymentResponse> getAllPayments(){
        return paymentRepository.findAll().stream().map(p ->{
                    PaymentResponse response= new PaymentResponse();
                    response.id=p.getId();
                    response.userId = p.getUserId();
                    response.planId = p.getPlanId();
                    response.amount = p.getAmount();
                    response.currency = p.getCurrency();
                    response.paymentType = p.getPaymentType();
                    response.paymentStatus = p.getPaymentStatus();
                    response.paymentDate = p.getPaymentDate();
                    response.transactionId = p.getTransactionId();
                    return response;
        })
                .collect(Collectors.toList());
    }
}
