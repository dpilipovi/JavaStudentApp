package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import hr.tvz.pilipovic.studapp.entities.CourseDTO;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import hr.tvz.pilipovic.studapp.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    public final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping()
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseByID(@PathVariable int id){
        return courseService.findById(id)
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
