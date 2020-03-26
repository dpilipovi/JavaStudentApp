package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentByJMBAG(final String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO).orElse(null);
    }

    private StudentDTO mapStudentToDTO(final Student student) {
        return new StudentDTO(student.getJMBAG(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()));
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth) {
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }

    /*
    LAB 1
    @Override
    public List<StudentDTO> findStudentBytuitionShouldBePaid(boolean tuitionShouldBePaid) {
       List<StudentDTO> lista=  studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
       lista=lista.stream().filter(s -> s.isTuitionShouldBePaid()==true).collect(Collectors.toList());
       return lista;
    }

    @Override
    public List<StudentDTO> findStudentByYear(int godina) {
        List<Student> lista=  studentRepository.findAll().stream().filter(s -> s.getDateOfBirth().getYear()<godina).collect(Collectors.toList());
        List<StudentDTO> rj=lista.stream().map(this::mapStudentToDTO).collect(Collectors.toList());
        return rj;
    }

     */
}
