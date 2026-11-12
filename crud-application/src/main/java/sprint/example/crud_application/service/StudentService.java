package sprint.example.crud_application.service;

import org.springframework.stereotype.Service;
import sprint.example.crud_application.entity.Student;
import sprint.example.crud_application.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent (Student studentreq){
        Student studentRes = studentRepository.save(studentreq);
        return studentRes;
    }


    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Student updateStudent(Long id, Student studentreq){
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            return null;
        }
        Student studentRes = student.get();

        studentRes.setName(studentreq.getName());
        studentRes.setAge(studentreq.getAge());
        studentRes.setSubject(studentreq.getSubject());
        studentRes.setEmail(studentreq.getEmail());
        studentRes.setRollno(studentreq.getRollno());

        return studentRepository.save(studentRes);

    }

    public Student deleteStudent(Long id) {
        
    }
}
