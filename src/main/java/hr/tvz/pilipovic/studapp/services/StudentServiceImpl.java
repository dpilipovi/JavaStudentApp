package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;

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
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO);
}

    private StudentDTO mapStudentToDTO(final Student student) {
        return new StudentDTO(student.getFirstName(),student.getLastName(),student.getJMBAG(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()), student.getDateOfBirth().toString(), student.getCourses());
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
    public long deleteStudentByJMBAG(String jmbag) {
         return studentRepository.deleteStudentByJMBAG(jmbag);

    }

    @Override
    public Optional<StudentDTO> editStudent(StudentCommand studentCommand) {
        Optional<Student> optional =studentRepository.findStudentByJMBAG(studentCommand.getJMBAG());

        Student s = optional.get();

        s.setFirstName(studentCommand.getFirstName());
        s.setLastName(studentCommand.getLastName());
        s.setDateOfBirth(studentCommand.getDateOfBirth());
        s.setNumberOfECTS(studentCommand.getNumberOfECTS());

        return Optional.of(mapStudentToDTO((studentRepository.save(s))));

    }

    @Override
    public List<StudentDTO> findStudentByFirstName(String firstname) {
        return studentRepository.findStudentByFirstName(firstname).stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByCourses_Name(String name) {
        return studentRepository.findByCourses_Name(name).stream().map(this::mapStudentToDTO).collect(Collectors.toList());
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
