//package service;
//
//import dto.RecruiterRequest;
//import entity.Recruiter;
//import entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import repository.JobRepository;
//import repository.RecruiterRepository;
//import repository.UserRepository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class RecruiterService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RecruiterRepository recruiterRepository;
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    public RecruiterRequest saveProfile(RecruiterRequest request){
//        Recruiter recruiter = new Recruiter();
//
//        User user = userRepository.findById(request.userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        recruiter.setUser(user);
//
//        recruiter.setCompanyName(request.companyName);
//        recruiter.setRecruiterName(request.recruiterName);
//        recruiter.setRecruiterEmail(request.recruiterEmail);
//        recruiter.setRecruiterPosition(request.recruiterPosition);
//        recruiter.setDesignation(request.designation);
//        recruiter.setCompanyWebsite(request.companyWebsite);
//        recruiter.setCompanyLocation(request.companyLocation);
//
//        Recruiter saved = recruiterRepository.save(recruiter);
//
//        RecruiterRequest response = new RecruiterRequest();
//        response.userId = saved.getUser().getId();
//        response.companyName = saved.getCompanyName();
//        response.recruiterName = saved.getRecruiterName();
//        response.recruiterEmail = saved.getRecruiterEmail();
//        response.recruiterPosition = saved.getRecruiterPosition();
//        response.designation =saved.getDesignation();
//        response.companyWebsite = saved.getCompanyWebsite();
//        response.companyLocation = saved.getCompanyLocation();
//
//        return response;
//    }
//
//    public List<RecruiterRequest> getAllRecruiters(){
//        return recruiterRepository.findAll().stream().map(recruiter ->{
//            RecruiterRequest dto = new RecruiterRequest();
//
//            dto.userId = recruiter.getUser() != null ? recruiter.getUser().getId() : null;
//
//            dto.companyName = recruiter.getCompanyName();
//            dto.recruiterName = recruiter.getRecruiterName();
//            dto.recruiterEmail = recruiter.getRecruiterEmail();
//            dto.recruiterPosition = recruiter.getRecruiterPosition();
//            dto.designation = recruiter.getDesignation();
//            dto.companyWebsite = recruiter.getCompanyWebsite();
//            dto.companyLocation = recruiter.getCompanyLocation();
//
//            return dto;
//        }).collect(Collectors.toList());
//    }
//    public RecruiterRequest getByRecruiterEmail(String recruiterEmail){
//        Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail)
//                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
//            RecruiterRequest dto = new RecruiterRequest();
//
//            dto.companyName = recruiter.getCompanyName();
//            dto.recruiterName = recruiter.getRecruiterName();
//            dto.recruiterEmail = recruiter.getRecruiterEmail();
//            dto.recruiterPosition = recruiter.getRecruiterPosition();
//            dto.designation = recruiter.getDesignation();
//            dto.companyWebsite = recruiter.getCompanyWebsite();
//            dto.companyLocation = recruiter.getCompanyLocation();
//
//            return dto;
//    }
//}
package service;

import dto.RecruiterRequest;
import dto.RecruiterResponse;
import entity.Recruiter;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JobRepository;
import repository.RecruiterRepository;
import repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private JobRepository jobRepository;

    public RecruiterResponse saveProfile(RecruiterRequest request) {
        Recruiter recruiter = new Recruiter();

        User user = userRepository.findById(request.userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        recruiter.setUser(user);

        recruiter.setCompanyName(request.companyName);
        recruiter.setRecruiterName(request.recruiterName);
        recruiter.setRecruiterEmail(request.recruiterEmail);
        recruiter.setRecruiterPosition(request.recruiterPosition);
        recruiter.setDesignation(request.designation);
        recruiter.setCompanyWebsite(request.companyWebsite);
        recruiter.setCompanyLocation(request.companyLocation);

        Recruiter saved = recruiterRepository.save(recruiter);

        return toResponse(saved);
    }

    public List<RecruiterResponse> getAllRecruiters() {
        return recruiterRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public RecruiterResponse getByRecruiterEmail(String recruiterEmail) {
        Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        return toResponse(recruiter);
    }

    // 🔑 mapper method (Entity → Response DTO)
    private RecruiterResponse toResponse(Recruiter recruiter) {
        RecruiterResponse dto = new RecruiterResponse();
        dto.userId = recruiter.getUser() != null ? recruiter.getUser().getId() : null;
        dto.companyName = recruiter.getCompanyName();
        dto.recruiterName = recruiter.getRecruiterName();
        dto.recruiterEmail = recruiter.getRecruiterEmail();
        dto.recruiterPosition = recruiter.getRecruiterPosition();
        dto.designation = recruiter.getDesignation();
        dto.companyWebsite = recruiter.getCompanyWebsite();
        dto.companyLocation = recruiter.getCompanyLocation();

        return dto;
    }
}
