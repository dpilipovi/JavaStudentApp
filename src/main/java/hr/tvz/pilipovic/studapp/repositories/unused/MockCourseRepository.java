/*package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Course;
import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import hr.tvz.pilipovic.studapp.entities.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class MockCourseRepository implements  CourseRepository {

    private List<Course> MOCKED_COURSES = new ArrayList<>(
            Arrays.asList(
                    new Course(0, "Java", 7),
                    new Course(1, "Android", 6)
            )
    );

    /**
     *
     * Metoda bi vracala broj courseva tako da pri dodavanju novog course mu mozemo dati novi id koji nije zauzet
     */
 /*   private int getNumberOfCourses()
    {
        return MOCKED_COURSES.size();
    }

    @Override
    public List<Course> findAll() {
        return MOCKED_COURSES;
    }

    @Override
    public List<Course> findByNameIgnoreCaseContaining(String name) {
       // return MOCKED_COURSES.stream().filter(it -> Objects.equals(it.getName(), name)).findAny();
        return null;
    }

    @Override
    public Optional<Course> findByStudents_JMBAG(String jmbag) {
        return Optional.empty();
    }

    @Override
    public Optional<Course> findById(long id) {
       return MOCKED_COURSES.stream().filter(it -> Objects.equals(it.getId(), id)).findAny();
    }

    @Override
    public Optional<Course> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Course> editCourse(CourseCommand courseCommand) {

        if(courseCommand.getNumberOfEcts()>7 || courseCommand.getNumberOfEcts()<1) return Optional.empty();

        MOCKED_COURSES.stream().filter(c -> courseCommand.getId()==(c.getId())).findFirst().get().setName(courseCommand.getName());
        MOCKED_COURSES.stream().filter(c -> courseCommand.getId()==(c.getId())).findFirst().get().setNumberOfEcts(courseCommand.getNumberOfEcts());

        return findById(courseCommand.getId());

    }
}*/
