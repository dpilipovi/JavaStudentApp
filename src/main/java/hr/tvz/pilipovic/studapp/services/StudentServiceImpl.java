package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import hr.tvz.pilipovic.studapp.repositories.StudentJdbcRepository;
import hr.tvz.pilipovic.studapp.repositories.StudentJpaRepository;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;
   // private final StudentJdbcRepository studentRepository;
    private final StudentJpaRepository studentRepository;

    public StudentServiceImpl(StudentJpaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentByJMBAG(final String JMBAG) {
        return Optional.of(mapStudentToDTO(studentRepository.findStudentByJMBAG(JMBAG)));//.map(this::mapStudentToDTO);
    }

    private StudentDTO mapStudentToDTO(final Student student) {
        return new StudentDTO(student.getJMBAG(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()));
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth) {
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }

    @Override
    public Optional<StudentDTO> save(StudentCommand student) {
       Student s = new Student(student.getFirstName(),student.getLastName(),student.getNumberOfECTS(),student.getDateOfBirth(),student.getJMBAG());
        return Optional.of(mapStudentToDTO(studentRepository.save(s)));//.map(this::mapStudentToDTO);
    }

    @Override

    public boolean deleteByJMBAG(String jmbag) {
         return studentRepository.deleteByJMBAG(jmbag);

    }

    @Override
    public Optional<StudentDTO> editEcts(int brojEcts, String JMBAG) {
        return Optional.of(mapStudentToDTO(studentRepository.editEcts(brojEcts, JMBAG)));//.map(this::mapStudentToDTO);
    }

    @Override
    public List<StudentDTO> findStudentByFirstName(String firstname) {
        return studentRepository.findStudentByFirstName(firstname).stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }



    /*
    LAB 1
    @Override
    public List<StudentDTO> findStudentBytuitionShouldBePaid(boolean tuitionShouldBePaid) {
       List<StudentDTO> lista=  studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
       lista=lista.stream().filter(s -> s.isTuitionShouldBePaid()==true).collect(Collectors.toList());
       return lista;
    }
*/

}
