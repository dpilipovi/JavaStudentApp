package hr.tvz.pilipovic.studapp.controllers;

import hr.tvz.pilipovic.studapp.entities.Lecturer;
import hr.tvz.pilipovic.studapp.services.LecturerService;
import hr.tvz.pilipovic.studapp.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("lecturer")
@CrossOrigin("http://localhost:4200")
public class LecturerController {

    public final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping()
    public List<Lecturer> getLecturers()
    {
        return lecturerService.getLecturers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturers(@PathVariable long id)
    {
        return lecturerService.getLecturerById(id)
                .map(
                        lecturer -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(lecturer))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }
}
