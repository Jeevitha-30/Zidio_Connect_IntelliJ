package service;

import dto.JobRequest;
import entity.JobListing;
import entity.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JobRepository;
import repository.RecruiterRepository;

import java.util.List;
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

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
        job.setPostedDate(request.postedDate);
        job.setRecruiterName(request.recruiterName);

        Recruiter recruiter = recruiterRepository.findById(request.recruiterId)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        job.setRecruiter(recruiter);

        jobRepository.save(job);

        return "Job post got saved";
    }

    public List<JobRequest> getAllJobs() {
        List<JobListing> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto).toList();
    }

    private JobRequest convertToDto(JobListing job) {
        JobRequest dto = new JobRequest();
        dto.id = job.getId();
        dto.title = job.getTitle();
        dto.description = job.getDescription();
        dto.companyName = job.getCompanyName();
        dto.location = job.getLocation();
        dto.jobType = job.getJobType();
        dto.skills = job.getSkills();
        dto.duration = job.getDuration();
        dto.postedDate = job.getPostedDate();
        dto.recruiterName = job.getRecruiterName();

        return dto;
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
