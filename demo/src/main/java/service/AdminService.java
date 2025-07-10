package service;

import dto.UserInfoResponse;
import dto.UserStatusUpdateRequest;
import entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserInfoRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

//    @Autowired
//    private UserInfoRepository userInfoRepository;
//
//    public UserInfoResponse updateUserStatus(UserStatusUpdateRequest request){
//
//        UserInfo user= userInfoRepository.findByEmail(request.email()).
//                orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setIsactive(request.isActive());
//        UserInfo saved= userInfoRepository.save(user);
//        return toResponse(saved);
//    }
//
//    public List<UserInfoResponse> getAllUsers(){
//        return userInfoRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
//    }
//
//    public List<UserInfoResponse>getUsersByRole(String role){
//        return userInfoRepository.findByRole(role.toUpperCase())
//                .stream()
//                .map(this::toResponse)
//                .collect(Collectors.toList());
//    }
//
//    public UserInfoResponse toResponse(UserInfo user){
//        return new UserInfoResponse(user.getEmail(),user.getRole(),user.getIsactive());
//    }
}
