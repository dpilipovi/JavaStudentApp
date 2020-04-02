package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Course;
import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import hr.tvz.pilipovic.studapp.entities.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {


    List<CourseDTO> findAll();

    Optional<CourseDTO> findByNaziv(String naziv);

    Optional<CourseDTO> findById(int id);

    Optional<CourseDTO> editCourse(CourseCommand courseCommand);
}
