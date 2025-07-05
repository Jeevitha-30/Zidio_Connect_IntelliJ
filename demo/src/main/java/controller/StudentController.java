package controller;

import dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/profile")
    public ResponseEntity<String> save(@RequestBody StudentDto dto){
        return ResponseEntity.ok(studentService.createOrUpdate(dto));
    }

    @GetMapping("profile/{email}")
    public ResponseEntity<StudentDto>get(@PathVariable String email){
        return ResponseEntity.ok(studentService.getProfile(email));
    }
//    @PutMapping("/profile")
//    public ResponseEntity<String> update(@RequestBody StudentDto dto) {
//        return ResponseEntity.ok(studentService.update(dto));
//    }
}
