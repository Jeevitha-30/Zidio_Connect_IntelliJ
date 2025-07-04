package service;

import entity.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JobRepository;
import repository.RecruiterRepository;

import java.util.Optional;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public Optional<Recruiter> getByCompanyName(String name){
        return recruiterRepository.findByCompanyName(name);
    }
    public Recruiter saveRecruiter(Recruiter recruiter){
        return recruiterRepository.save(recruiter);
    }
}
