package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Course;
//import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CourseRepository {

    List<Course> findAll();

  /*  List<Course> findByNameIgnoreCaseContaining(String name);

    Optional<Course> findByStudents_JMBAG(String jmbag);

  //  Optional<Course> editCourse(CourseCommand courseCommand);

    Optional<Course> findById(long id);

    Optional<Course> findByName(String name);*/


}
