package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Course;
import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CourseRepository {

    List<Course> findAll();

    Optional<Course> findByName(String name);

    Optional<Course> findById(int id);

    Optional<Course> editCourse(CourseCommand courseCommand);
}
