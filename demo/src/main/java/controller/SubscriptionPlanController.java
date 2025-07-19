package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.SubscriptionPlanDto;
import service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService  subscriptionPlanService;

    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDto>>getAll(){
        return ResponseEntity.ok(subscriptionPlanService.getAllSubscriptionPlan());
    }

    @PostMapping
    public ResponseEntity<SubscriptionPlanDto> create(@RequestBody SubscriptionPlanDto dto) {
        return ResponseEntity.ok(subscriptionPlanService.createSubscription(dto));
    }
}
