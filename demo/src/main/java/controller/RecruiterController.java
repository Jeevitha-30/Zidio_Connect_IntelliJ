package controller;

import dto.RecruiterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.RecruiterRepository;
import service.RecruiterService;

import java.util.List;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController{

    @Autowired
    private RecruiterService recruiterService;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerRecruiter(@RequestBody RecruiterRequest request) {
        if (recruiterRepository.findByRecruiterEmail(request.recruiterEmail).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Recruiter with this email already exists");
        }
        recruiterService.saveProfile(request);
        return ResponseEntity.ok("Recruiter registered successfully");
    }


    @GetMapping("/all")
    public ResponseEntity<List<RecruiterRequest>>getAll(){
        return ResponseEntity.ok(recruiterService.getAllRecruiters());
    }

    @GetMapping("/{recruiterEmail}")
    public ResponseEntity<RecruiterRequest> getByRecruiterEmail(@PathVariable String recruiterEmail) {
        return ResponseEntity.ok(recruiterService.getByRecruiterEmail(recruiterEmail));
    }

}
