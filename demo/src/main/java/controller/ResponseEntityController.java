package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import security.JwtUtil;

@RestController
public class ResponseEntityController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam String token) {
        boolean isValid = jwtUtil.validateToken(token);
        return isValid
                ? ResponseEntity.ok("Valid Token")
                : ResponseEntity.status(401).body("Invalid Token");
    }
}

