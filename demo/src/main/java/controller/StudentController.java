package controller;

import dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/profile")
    public ResponseEntity<String> save(@RequestBody StudentDto dto){
        return ResponseEntity.ok(studentService.create(dto));
    }
    @GetMapping("/profile/{email}")
    public ResponseEntity<StudentDto>get(@PathVariable String email){
        return ResponseEntity.ok(studentService.getProfile(email));
    }
    @PutMapping("/profile")
    public ResponseEntity<String> update(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.update(dto));
    }
    @DeleteMapping("/profile/{email}")
    public ResponseEntity<String> delete(@PathVariable String email) {
        studentService.deleteByEmail(email);
        return ResponseEntity.ok("Student deleted successfully");
    }
    @GetMapping("/profile")
    public ResponseEntity<StudentDto> getOwnProfile(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body(null);
        }

        String email = authentication.getName();  // Extract email from token's principal

        StudentDto profile = studentService.getProfile(email);

        return ResponseEntity.ok(profile);
    }


}
