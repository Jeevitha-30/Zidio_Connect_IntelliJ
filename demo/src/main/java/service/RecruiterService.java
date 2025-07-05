package service;

import dto.JobRequest;
import entity.JobListing;
import entity.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JobRepository;
import repository.RecruiterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private JobRepository jobRepository;

    public Recruiter saveProfile(Recruiter r){
        return recruiterRepository.save(r);
    }

    public JobListing postJob(JobRequest request){
        JobListing job = new JobListing();

        job.setTitle(request.title);
        job.setDescription(request.description);
        job.setJobType(request.jobType);
        job.setLocalDate(request.localDate);
        job.setLocation(request.location);

        return jobRepository.save(job);
    }
    public List<JobListing> getPostedJob(String recruiterEmail){
        return jobRepository.findByPostedBy(recruiterEmail);
    }
    public List<JobListing> gtAllJobs(){
        return jobRepository.findAll();
    }

}
