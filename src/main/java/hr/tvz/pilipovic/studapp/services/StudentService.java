package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> findAll();

    Optional<StudentDTO> findStudentByJMBAG(String JMBAG);

    Optional<StudentDTO> save(StudentCommand command);

    boolean deleteByJMBAG(String jmbag);




    /*
    LAB 1
    List<StudentDTO> findStudentBytuitionShouldBePaid(boolean tuitionShouldBePaid);

    */

}
