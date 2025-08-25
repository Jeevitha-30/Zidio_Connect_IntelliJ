package service;

import java.time.LocalDate;
import java.util.Optional;

import dto.UserPaymentStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.UserPaymentStatus;
import enums.PaidStatus;
import repository.UserPaymentStatusRepository;

@Service
public class UserPaymentStatusService {

    @Autowired
    private UserPaymentStatusRepository userPaymentStatusRepository;

    public UserPaymentStatusDto assignSubscriptionPlan(UserPaymentStatusDto dto) {
        UserPaymentStatus paymentStatus = new UserPaymentStatus();
        paymentStatus.setUserId(dto.userId);
        paymentStatus.setPlanId(dto.planId);


        // Use provided dates if not null, otherwise auto-generate
        LocalDate startDate = dto.subscriptionStart != null ? dto.subscriptionStart : LocalDate.now();
        LocalDate endDate = dto.subscriptionEnd != null ? dto.subscriptionEnd : startDate.plusDays(30);

        paymentStatus.setSubscriptionStart(startDate);
        paymentStatus.setSubscriptionEnd(endDate);

        // Default status to ACTIVE if not provided
        paymentStatus.setStatus(dto.status != null ? dto.status : PaidStatus.ACTIVE);

        UserPaymentStatus saved = userPaymentStatusRepository.save(paymentStatus);

        // Update DTO from saved entity
        dto.id = saved.getId();
        dto.subscriptionStart = saved.getSubscriptionStart();
        dto.subscriptionEnd = saved.getSubscriptionEnd();
        dto.status = saved.getStatus();
        return dto;
    }

    public Optional<UserPaymentStatusDto> getStatusByUserId(Long id) {
        return userPaymentStatusRepository.findByUserId(id).map(status -> {
            UserPaymentStatusDto dto = new UserPaymentStatusDto();
            dto.id = status.getId();
            dto.planId = status.getPlanId();
            dto.userId = status.getUserId();
            dto.subscriptionStart = status.getSubscriptionStart();
            dto.subscriptionEnd = status.getSubscriptionEnd();
            dto.status = status.getStatus();
            return dto;
        });
    }
}