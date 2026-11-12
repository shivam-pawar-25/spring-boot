package sprint.example.crud_application.repository;

import org.springframework.stereotype.Component;
import sprint.example.crud_application.entity.Student;

@Component
public class StudentRepository {

    public Student saveStudent (Student studentReq ){
        System.out.println("Repository");
        Student s = new Student();
        s.setName(studentReq.getName());
        s.setAge(studentReq.getAge());
        s.setEmail(studentReq.getEmail());
        s.setSubject(studentReq.getSubject());
        s.setRollNO(studentReq.getRollNO());
        return s ;
    }




}


