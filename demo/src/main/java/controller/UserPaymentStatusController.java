package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UserPaymentStatusDto;
import service.UserPaymentStatusService;

@RestController
@RequestMapping("/api/user_subscrption_status")
public class UserPaymentStatusController {

    @Autowired
    private UserPaymentStatusService userPaymentStatusService;


    @PostMapping
    public ResponseEntity<UserPaymentStatusDto>assign(@RequestBody UserPaymentStatusDto dto ){
        return ResponseEntity.ok(userPaymentStatusService.assignSubscriptionPlan(dto));
    }

    @GetMapping("{userId}")
    public ResponseEntity<Optional<UserPaymentStatusDto>> getStatus(@PathVariable Long userId){
        return ResponseEntity.ok(userPaymentStatusService.getStatusByUserId(userId));
    }

}
