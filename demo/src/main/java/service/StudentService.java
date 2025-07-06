package service;
import entity.Student;
import dto.StudentDto;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import repository.UserRepository;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    public String create(StudentDto dto){

        User user = userRepository.findByEmail(dto.email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + dto.email));

        Student student = studentRepository.findByEmail(dto.email).orElse(new Student());

        student.setUser(user);

        student.setName(dto.name);
        student.setEmail(dto.email);
        student.setDegree(dto.degree);
        student.setUniversity(dto.university);
        student.setResumeUrl(dto.resumeUrl);
        student.setYearOfStudy(dto.yearOfStudy);

        studentRepository.save(student);

        return "Student Profile got saved";
    }
    public String update(StudentDto dto) {
        Student student = studentRepository.findByEmail(dto.email)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + dto.email));

        student.setName(dto.name);
        student.setEmail(dto.email);
        student.setDegree(dto.degree);
        student.setUniversity(dto.university);
        student.setResumeUrl(dto.resumeUrl);
        student.setYearOfStudy(dto.yearOfStudy);

        studentRepository.save(student);

        return "Student Profile updated";
    }
    public StudentDto getProfile(String email){
        Student s =studentRepository.findByEmail(email).orElseThrow();
        StudentDto dto= new StudentDto();
        dto.name=s.getName();
        dto.email=s.getEmail();
        dto.degree=s.getDegree();
        dto.university=s.getUniversity();
        dto.resumeUrl=s.getResumeUrl();
        return dto;
    }
    public void deleteByEmail(String email) {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }

}
