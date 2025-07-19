package dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import enums.PaymentType;
import enums.PaymentStatus;

public class PaymentRequest {
    public Long userId;
    public Long planId;
    public BigDecimal amount;
    public String currency;
    public PaymentType paymentType;
    public PaymentStatus paymentStatus;
    public LocalDateTime paymentDate;
    public String transactionId;
}

