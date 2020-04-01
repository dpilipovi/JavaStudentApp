package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {


    List<StudentDTO> lista = new ArrayList<>();

    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String JMBAG);

    Optional<Student> save(StudentCommand student);

    boolean deleteByJMBAG(String jmbag);
}
