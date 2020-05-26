package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Course;
import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByNameIgnoreCaseContaining(String name);

   // Course save(CourseCommand course);

    Course save(Course course);

    List<Course> findByStudents_JMBAG(String jmbag);

    Course findById(long id);

    Course findByName(String name);
}
