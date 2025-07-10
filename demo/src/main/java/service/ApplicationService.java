package service;

import dto.ApplicationRequest;
import dto.ApplicationResponse;
import entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ApplicationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public ApplicationResponse apply(ApplicationRequest request){
        applicationRepository.findByStudentEmailAndJobId(request.studentEmail,request.jobId).
                ifPresent(a->{throw new RuntimeException("Already applied");});


        Application app = new Application();
        app.setStudentEmail(request.studentEmail);
        app.setJobId(request.jobId);
        app.setStatus("applied");

        app = applicationRepository.save(app);
        ApplicationResponse response = new ApplicationResponse();
        response.jobId = app.getJobId();
        response.studentEmail = app.getStudentEmail();
        response.status = app.getStatus();
        return response;

    }
    public List<ApplicationResponse> getApplicationsByStudent(String studentEmail){
        return applicationRepository.findByStudentEmail(studentEmail)
                .stream()
                .map(this::mapToResponse).
                collect(Collectors.toList());
    }
    public List<ApplicationResponse> getApplicationByJob(Long jobId){
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());}
    private ApplicationResponse mapToResponse(Application app) {
        ApplicationResponse response = new ApplicationResponse();
        response.jobId = app.getJobId();
        response.studentEmail = app.getStudentEmail();
        response.status = app.getStatus();
        return response;
    }
}
