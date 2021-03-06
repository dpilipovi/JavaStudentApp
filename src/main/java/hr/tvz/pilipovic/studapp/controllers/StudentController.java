package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.*;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import hr.tvz.pilipovic.studapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
//jdbc:h2:mem:testdb
@RestController
@RequestMapping("student")
@CrossOrigin(origins="http://localhost:4200")
public class StudentController {

    public final StudentService  studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping()
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @Secured({"ROLE_ADMIN"})
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

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/getStudentsByFirstName/{firstname}")
    public List<StudentDTO> getStudentsByFirstname(@PathVariable String firstname){
        return studentService.findStudentByFirstName(firstname);

    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/getStudentsByCourse/{name}")
    public List<StudentDTO> getStudentsByCourse(@PathVariable String name)
    {
        return studentService.findByCourses_Name(name);
    }

    @Secured({"ROLE_ADMIN"})
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

    @Secured({"ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<StudentDTO> editStudent(@RequestBody StudentCommand studentCommand)
    {
        return studentService.editStudent(studentCommand)
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

    @Secured({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public ResponseEntity delete(@PathVariable String JMBAG){

      if(studentService.deleteStudentByJMBAG(JMBAG)>0) return ResponseEntity.status(HttpStatus.OK).build();
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
