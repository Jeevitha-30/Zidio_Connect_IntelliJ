package repository;

import entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobListing,Long> {
    Optional<JobListing> findByCompanyNameAndTitle(String CompanyName, String Title);
    List<JobListing> findByCompanyName(String companyName);
    List<JobListing> findByTitle(String title);
    List<JobListing> findByEmployerName(String employerName);

}
