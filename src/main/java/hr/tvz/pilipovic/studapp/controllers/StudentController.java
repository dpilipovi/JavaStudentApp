package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import hr.tvz.pilipovic.studapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    public final StudentService  studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String JMBAG){
        return studentService.findStudentByJMBAG(JMBAG)
                .map(
                student -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(student))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody final StudentCommand student){
        return studentService.save(student)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void delete(@PathVariable String JMBAG){
        studentService.deleteByJMBAG(JMBAG);
    }

    /* LAB 1
    @GetMapping("/neplacaju")
    public List<StudentDTO> getStudentNotPaying()
    {
        boolean tuitionShouldBePaid = true;
        List<StudentDTO> s =new ArrayList<>();
        s = studentService.findStudentBytuitionShouldBePaid(tuitionShouldBePaid);
        return s;
    }
     */
}
