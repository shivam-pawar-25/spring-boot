package sprint.example.crud_application.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sprint.example.crud_application.entity.Student;
import sprint.example.crud_application.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent (Student studentreq){
        System.out.println("Sevice");
        Student studentRes = studentRepository.saveStudent(studentreq);
        return studentRes;
    }
}
