package sprint.example.crud_application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint.example.crud_application.entity.Student;
import sprint.example.crud_application.repository.StudentRepository;
import sprint.example.crud_application.service.StudentService;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService  = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        System.out.println("Controller");
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
}
