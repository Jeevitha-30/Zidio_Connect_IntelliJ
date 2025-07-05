package service;

import dto.JobRequest;
import entity.JobListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import repository.JobRepository;

import java.util.List;
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public String jobListing(JobRequest request)
    {
        JobListing job = new JobListing();

        job.setTitle(request.title);
        job.setDescription(request.description);
        job.setCompanyName(request.companyName);
        job.setJobType(request.jobType);
        job.setLocation(request.location);
        job.setSkills(request.skills);
        job.setDuration(request.duration);

        jobRepository.save(job);

        return "Job post got saved";

    }
    public List<JobListing> getAllJobs()
    {
        return jobRepository.findAll();
    }
    public List<JobListing> getByTitle(String title)
    {
        return jobRepository.findByTitle(title);
    }
    public List<JobListing> getByCompanyName(String companyName)
    {
        return jobRepository.findByCompanyName(companyName);
    }
}
