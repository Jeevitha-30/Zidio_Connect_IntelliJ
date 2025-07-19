package dto;

import java.time.LocalDate;
import enums.PaidStatus;

public class UserPaymentStatusDto {

    public Long id;
    public Long planId;
    public Long userId;
    public LocalDate subscriptionStart;
    public LocalDate subscriptionEnd;
    public PaidStatus status;

    public UserPaymentStatusDto() {}

    public UserPaymentStatusDto(Long id,Long planId,Long userId,LocalDate subscriptionStart,LocalDate subscriptionEnd,PaidStatus status) {
        this.id=id;
        this.planId=planId;
        this.userId=userId;
        this.subscriptionStart=subscriptionStart;
        this.subscriptionEnd=subscriptionEnd;
        this.status=status;
    }
}
