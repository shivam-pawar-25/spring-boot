package sprint.example.crud_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity     //this class is not bean the object is manage by jpa
public class Student {
    //class for creating structure for student

    @Id
    private  int Id;
    private String name;
    private int age;
    private String email;
    private int rollNO;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNO() {
        return rollNO;
    }

    public void setRollNO(int rollNO) {
        this.rollNO = rollNO;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
