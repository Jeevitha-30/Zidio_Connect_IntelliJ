package dto;

import java.math.BigDecimal;

public class SubscriptionPlanDto {

    public Long planId;
    public String name;
    public BigDecimal price;
    public String description;
    public Integer durationInDays;

    public SubscriptionPlanDto() {}

    public SubscriptionPlanDto(Long planId,String name,String description,BigDecimal price,Integer durationInDays) {
        this.planId=planId;
        this.name=name;
        this.description=description;
        this.price=price;
        this.durationInDays=durationInDays;
    }
}
