package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Course;
import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    Course findByName(String name);

    Course findById(long id);

    Course save(CourseCommand course);

    Course save(Course course);
}
