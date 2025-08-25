package controller;

import java.util.List;
import java.util.Map;

import dto.JobRequest;
import entity.JobListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.JobRepository;
import service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/jobpost")
    public ResponseEntity<String>postJob(@RequestBody JobRequest request){
        return ResponseEntity.ok(jobService.jobListing(request));
    }
//    @GetMapping("/all")
//    public ResponseEntity<List<JobListing>>getAllJobs(){
//        return ResponseEntity.ok(jobService.getAllJobs());
//    }

    @GetMapping("/all")
    public List<JobRequest> getAllJobs() {
        return jobService.getAllJobs();
    }


    @GetMapping("search/title/{title}")
    public ResponseEntity<List<JobListing>>searchByTitle(@PathVariable String title){
        return ResponseEntity.ok(jobService.getByTitle(title));

    }
    @GetMapping("/search/companyName/{companyName}")
    public ResponseEntity<List<JobListing>>searchByCompanyName(@PathVariable String companyName){
        return ResponseEntity.ok(jobService.getByCompanyName(companyName));
    }

}
