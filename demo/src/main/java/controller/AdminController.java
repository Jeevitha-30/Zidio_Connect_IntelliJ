package controller;

import dto.UserInfoResponse;
import dto.UserStatusUpdateRequest;
import entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/user")
    public UserInfoResponse addUser(@RequestBody UserInfo userInfo) {
        return adminService.addUser(userInfo);
    }

    @PutMapping("/user/status")
    public UserInfoResponse updateUserStatus(@RequestBody UserStatusUpdateRequest request ){
        return adminService.updateUserStatus(request);
    }

    @GetMapping("/user")
    public List<UserInfoResponse>getAllUsers(){
        return adminService.getAllUsers();
    }

    @GetMapping("/user/{role}")
    public List<UserInfoResponse> getUserByRole(@PathVariable String role ){
        return adminService.getUsersByRole(role);
    }
}
