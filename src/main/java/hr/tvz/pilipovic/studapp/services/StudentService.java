package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findStudentByJMBAG(String JMBAG);

    /*
    LAB 1
    List<StudentDTO> findStudentBytuitionShouldBePaid(boolean tuitionShouldBePaid);


    List<StudentDTO> findStudentByYear(int godina);

    */

}
