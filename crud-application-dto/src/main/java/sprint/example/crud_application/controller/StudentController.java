package sprint.example.crud_application.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.example.crud_application.dto.StudentRequestDto;
import sprint.example.crud_application.dto.StudentResponseDto;
import sprint.example.crud_application.entity.Student;
import sprint.example.crud_application.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService  = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@Valid @RequestBody StudentRequestDto student) {
        StudentResponseDto createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = studentService.getAllStudents();
        if(list == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id ,@RequestBody Student studentreq) {
        Student student = studentService.updateStudent(id , studentreq);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id ) {
         Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted");
    }
}
