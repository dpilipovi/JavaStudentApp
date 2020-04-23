package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.*;
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
@CrossOrigin("http://localhost:4200")
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
                                .status(HttpStatus.OK)
                                .body(student))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @GetMapping("/getStudentsByFirstName/{firstname}")
    public List<StudentDTO>getStudentsByFirstname(@PathVariable String firstname){
        System.out.println(firstname);
        return studentService.findStudentByFirstName(firstname);

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

    @PutMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> editEcts(@RequestBody int brojEcts, @PathVariable String JMBAG)
    {
        return studentService.editEcts(brojEcts,JMBAG)
                .map(
                        student -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(student))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public ResponseEntity delete(@PathVariable String JMBAG){

      if(studentService.deleteByJMBAG(JMBAG)) return ResponseEntity.status(HttpStatus.OK).build();
      else  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
