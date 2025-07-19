package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="subscription_plans")
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer durationInDays;

    public SubscriptionPlan() {}

    public SubscriptionPlan(Long planId, String name, String description, BigDecimal price, Integer durationInDays) {
        this.planId = planId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationInDays = durationInDays;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setId(Long planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }
}