package service;
import entity.Student;
import dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String createOrUpdate(StudentDto dto){
        Student student = studentRepository.findByEmail(dto.email).orElse(new Student());
        student.setName(dto.name);
        student.setEmail(dto.email);
        student.setCourse(dto.course);
        student.setUniversity(dto.university);
        student.setResumeUrl(dto.resumeUrl);
        studentRepository.save(student);

        return "Student Profile got saved";
    }
    public StudentDto getProfile(String email){
        Student s =studentRepository.findByEmail(email).orElseThrow();
        StudentDto dto= new StudentDto();
        dto.name=s.getName();
        dto.email=s.getEmail();
        dto.course=s.getCourse();
        dto.university=s.getUniversity();
        dto.resumeUrl=s.getResumeUrl();
        return dto;
    }
}
