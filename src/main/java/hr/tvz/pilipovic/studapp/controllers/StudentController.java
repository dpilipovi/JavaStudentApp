package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import hr.tvz.pilipovic.studapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    public final StudentService  studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("")
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(params = "JMBAG")
    public StudentDTO getStudent(@RequestParam String JMBAG){

        System.out.println(JMBAG);
        return studentService.findStudentByJMBAG(JMBAG);
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

    @GetMapping(params ="godina")
    public List<StudentDTO> getStudentByYear(@RequestParam Integer godina)
    {
        List<StudentDTO> s = new ArrayList<>();
        s = studentService.findStudentByYear(godina);
        return s;
    }

     */
}
