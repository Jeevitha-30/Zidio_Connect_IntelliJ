package service;

import dto.JobRequest;
import entity.JobListing;
import org.springframework.beans.factory.annotation.Autowired;
import repository.JobRepository;

import java.util.List;

public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public String jobListing(JobRequest request)
    {
        JobListing job = new JobListing();

        job.setTitle(request.title);
        job.setDescription(request.description);
//        job.setCompanyName(request.companyName);
//        job.setType(request.type);
        job.setLocation(request.location);
//        job.setSkills(request.skills);
//        job.setRemote(request.remote);
//        job.setDurationWeeks(request.durationWeeks);
//        job.setStipend(request.stipend);
//        job.setPostedAt(request.postedAt);
        job.setJobType(request.jobType);

        jobRepository.save(job);

        return "Job post got saved";

    }

    public List<JobListing> getAllJobs()
    {
        return jobRepository.findAll();
    }

    public List<JobListing> searchByTitle(String title)
    {
        return jobRepository.findByTitle(title);
    }

    public List<JobListing> searchBycompanyName(String companyName)
    {
        return jobRepository.findByCompanyName(companyName);
    }

}
