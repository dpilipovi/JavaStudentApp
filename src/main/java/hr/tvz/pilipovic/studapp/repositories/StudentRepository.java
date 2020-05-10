package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {


    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String JMBAG);

    Optional<Student> save(StudentCommand student);

    long deleteStudentByJMBAG(String jmbag);

    Optional<Student> editStudent(Student student, String JMBAG);

    List<Student> findStudentByFirstName(String firstname);

    List<Student> findByCourses_Name(String name);
}
