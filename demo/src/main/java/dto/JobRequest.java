package dto;

import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

public class JobRequest {
    public Long id;
    public String title;
    public String description;
    public String location;
    public String jobType;
    public String companyName;
    public String skills;
    public String duration;
    public String postedDate;
    public Long recruiterId;
    public String recruiterName;
}
