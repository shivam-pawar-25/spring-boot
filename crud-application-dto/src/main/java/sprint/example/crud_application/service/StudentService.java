package sprint.example.crud_application.service;

import org.springframework.stereotype.Service;
import sprint.example.crud_application.dto.StudentRequestDto;
import sprint.example.crud_application.dto.StudentResponseDto;
import sprint.example.crud_application.entity.Student;
import sprint.example.crud_application.exeption.ResourceNotFound;
import sprint.example.crud_application.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto createStudent (StudentRequestDto studentreq){


        Student student = mapCreateDtoToStudent(studentreq);
        Student studentmean= studentRepository.save(student);
        StudentResponseDto studentRes = mapCreateStudentToDto(studentmean);
        return studentRes;
    }


    public Student getStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Student with id " + id + " not found"));

        return student;
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

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }


    private Student mapCreateDtoToStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();

        student.setRollno(studentRequestDto.getRollno());
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setSubject(studentRequestDto.getSubject());
        student.setAge(studentRequestDto.getAge());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private StudentResponseDto mapCreateStudentToDto(Student student){
        StudentResponseDto studentResponsetDto = new StudentResponseDto();


        studentResponsetDto.setRollno(student.getRollno());
        studentResponsetDto.setName(student.getName());
        studentResponsetDto.setEmail(student.getEmail());
        studentResponsetDto.setSubject(student.getSubject());
        studentResponsetDto.setAge(student.getAge());
        studentResponsetDto.setId(student.getId());
        studentResponsetDto.setMessage("Task is completed");

        return studentResponsetDto;
    }

}
