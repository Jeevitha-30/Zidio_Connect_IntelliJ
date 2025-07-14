package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.ApplicationService;
import dto.ApplicationRequest;
import dto.ApplicationResponse;

@RestController
@RequestMapping("/api/applications")

public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ApplicationResponse apply(@RequestBody ApplicationRequest request){

        return applicationService.apply(request);
    }

    @GetMapping("/student/{email}")
    public List<ApplicationResponse>getByStudentEmail(@PathVariable("email") String email){

        return applicationService.getApplicationsByStudent(email);
    }

    @GetMapping("/job/{jobId}")
    public List<ApplicationResponse>getByJobId(@PathVariable Long jobId){

        return applicationService.getApplicationByJob(jobId);

    }
}
