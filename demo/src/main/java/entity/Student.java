package entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private Long userId;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @MapsId
    private User user;
    private String name;
    private String email;
    //    private String course;
    private String university;
    private String degree;
    private int yearOfStudy;
    private String resumeUrl;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getYearOfStudy() {

        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {

        this.yearOfStudy = yearOfStudy;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
}
