package sprint.example.crud_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sprint.example.crud_application.entity.Student;

import java.net.InterfaceAddress;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {






}


/*jpa (jakarta persistance api )
    provide way to interact with DB layer
    Methods provided
        save() : use to insert the row in Table
        findAll() : return all rows
        find() : return single or replace select query
        deleteById() : delete record
        save() : to update
        exisById() : is record present
 */