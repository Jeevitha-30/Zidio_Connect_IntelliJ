package service;

import dto.LoginRequest;
import dto.RegisterRequest;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import security.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request){
        if(userRepository.findByEmail(request.email).isPresent()) {
            return "Email already registered. Please login.";
        }
        User user = new User();
        user.setEmail(request.email);
        user.setPassword(new BCryptPasswordEncoder().encode(request.password));
        user.setRole(request.role);

        userRepository.save(user);
        return "User Registered Successfully";
    }
    public Map<String, String> login(LoginRequest request){
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(()->new RuntimeException("User not found"));
        if(!new BCryptPasswordEncoder().matches(request.password,user.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        String token = jwtUtil.generateToken(user.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("email", user.getEmail());
        response.put("role", user.getRole());  // NOT user.getTroll().name()
        response.put("token", token);

        return response;
    }
}
