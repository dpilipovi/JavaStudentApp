package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.*;
import hr.tvz.pilipovic.studapp.repositories.CourseRepository;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements  CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
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
    public Optional<CourseDTO> findByNaziv(String name) {
        return courseRepository.findByName(name).map(this::mapCourseToDTO);
    }

    @Override
    public Optional<CourseDTO> findById(int id) {
        return courseRepository.findById(id).map(this::mapCourseToDTO);
    }

    @Override
    public Optional<CourseDTO> editCourse(CourseCommand courseCommand) {
        return courseRepository.editCourse(courseCommand).map(this::mapCourseToDTO);
    }
}
