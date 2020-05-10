package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import hr.tvz.pilipovic.studapp.entities.CourseDTO;
import hr.tvz.pilipovic.studapp.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @GetMapping()
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/{jmbag}")
    public List<CourseDTO> getCoursesByStudentJmbag(@PathVariable String jmbag){
        return courseService.findByStudents_JMBAG(jmbag);
    }

    @GetMapping(params = "JMBAG")
    public List<CourseDTO> getCoursesByStudentJmbag2(@RequestParam String jmbag){
        return courseService.findByStudents_JMBAG(jmbag);
    }

    @GetMapping("/findByName/{name}")
    public List<CourseDTO> getAllCoursesByName(@PathVariable String name)
    {
        return courseService.findCoursesByName(name);
    }

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
    }
}
