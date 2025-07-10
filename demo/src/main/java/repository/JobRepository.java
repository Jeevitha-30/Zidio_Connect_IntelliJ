package repository;

import entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobListing,Long> {
    List<JobListing> findByCompanyNameAndTitle(String CompanyName, String Title);
    List<JobListing> findByCompanyName(String companyName);
    List<JobListing> findByTitle(String title);
    List<JobListing> findByRecruiterName(String employerName);


}
