package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.SubscriptionPlanDto;
import entity.SubscriptionPlan;
import repository.SubscriptionPlanRepository;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;


    public List<SubscriptionPlanDto> getAllSubscriptionPlan(){
        return subscriptionPlanRepository.findAll().stream().map(sub ->{
            SubscriptionPlanDto dto = new SubscriptionPlanDto();
            dto.planId=sub.getPlanId();
            dto.name=sub.getName();
            dto.price=sub.getPrice();
            dto.description=sub.getDescription();
            dto.durationInDays=sub.getDurationInDays();
            return dto;
        }).collect(Collectors.toList());
    }

    public SubscriptionPlanDto createSubscription(SubscriptionPlanDto dto) {
        SubscriptionPlan subcription= new SubscriptionPlan();
        subcription.setName(dto.name);
        subcription.setPrice(dto.price);
        subcription.setDescription(dto.description);
        subcription.setDurationInDays(dto.durationInDays);

        SubscriptionPlan saved = subscriptionPlanRepository.save(subcription);
        dto.planId= saved.getPlanId();
        return dto;
    }
}
