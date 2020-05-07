package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.*;
import hr.tvz.pilipovic.studapp.repositories.CourseJpaRepository;
import hr.tvz.pilipovic.studapp.repositories.CourseRepository;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements  CourseService{

    private final CourseJpaRepository courseRepository;

    public CourseServiceImpl(CourseJpaRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    private CourseDTO mapCourseToDTO(final Course course) {
        return new CourseDTO(course.getName(), course.getNumberOfEcts());
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByStudents_JMBAG(String jmbag) {
        return courseRepository.findByStudents_JMBAG(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CourseDTO> editCourse(CourseCommand courseCommand) {
        return Optional.of(mapCourseToDTO(courseRepository.save(courseCommand)));//.map(this::mapCourseToDTO);
    }

    @Override
    public Optional<CourseDTO> findById(long id) {
        return Optional.of(mapCourseToDTO(courseRepository.findById(id)));
    }

    @Override
    public List<CourseDTO> findCoursesByName(String name) {
        return courseRepository.findByNameIgnoreCaseContaining(name).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CourseDTO> findByName(String name) {
        return Optional.of(mapCourseToDTO(courseRepository.findByName(name)));
    }
}
