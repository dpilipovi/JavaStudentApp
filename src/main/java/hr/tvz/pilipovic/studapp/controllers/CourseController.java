package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import hr.tvz.pilipovic.studapp.entities.CourseDTO;
import hr.tvz.pilipovic.studapp.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("course")
@CrossOrigin("http://localhost:4200")
public class CourseController {

    public final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping()
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/{jmbag}")
    public List<CourseDTO> getCoursesByStudentJmbag(@PathVariable String jmbag){
        return courseService.findByStudents_JMBAG(jmbag);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping(params = "JMBAG")
    public List<CourseDTO> getCoursesByStudentJmbag2(@RequestParam String jmbag){
        return courseService.findByStudents_JMBAG(jmbag);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/findByName/{name}")
    public List<CourseDTO> getAllCoursesByName(@PathVariable String name)
    {
        return courseService.findCoursesByName(name);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/findCourseByName/{name}")
    public ResponseEntity<CourseDTO> getCourseByName(@PathVariable String name)
    {
        return courseService.findByName(name)
                .map(
                        course -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(course))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

/*
    @Secured({"ROLE_ADMIN"})
    @PutMapping()
    public ResponseEntity<CourseDTO> editCourse(@RequestBody CourseCommand courseCommand)
    {
        return courseService.editCourse(courseCommand)
                .map(
                        course -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(course))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }*/
}
