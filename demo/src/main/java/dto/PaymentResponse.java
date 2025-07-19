package dto;

import enums.PaymentStatus;
import enums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponse {
    public Long id;
    public Long userId;
    public Long planId;
    public BigDecimal amount;
    public String currency;
    public PaymentType paymentType;
    public PaymentStatus paymentStatus;
    public LocalDateTime paymentDate;
    public String transactionId;
}
