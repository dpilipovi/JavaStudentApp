package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MockStudentRepository implements StudentRepository {


    private List<Student> MOCKED_STUDENTS = new ArrayList<>(
            Arrays.asList(
                    new Student("Pero", "Peric", 120, LocalDate.now().minusYears(27), "0246077777"),
                    new Student("Ilija", "Ilic", 100, LocalDate.now().minusYears(20), "0246033333")
            )
    );

    @Override
    public List<Student> findAll() {
        return MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(final String JMBAG) {
        return MOCKED_STUDENTS.stream().filter(it -> Objects.equals(it.getJMBAG(), JMBAG)).findAny();
    }

    @Override
    public Optional<Student> save(StudentCommand student) {
        if(!containsJMBAG(student.getJMBAG()))
        {
            MOCKED_STUDENTS.add(mapStudentCommandToStudent(student));
            return Optional.of(MOCKED_STUDENTS.get(MOCKED_STUDENTS.size() - 1));
        }

        return Optional.empty();

    }

    @Override
    public long deleteStudentByJMBAG(String jmbag) {
        if(containsJMBAG(jmbag))
        {
            //System.out.println(jmbag);
            MOCKED_STUDENTS=MOCKED_STUDENTS.stream().filter(student -> !student.getJMBAG().equals(jmbag)).collect(Collectors.toList());
            return 1;
        }
        return 0;
        //MOCKED_STUDENTS.removeIf(s -> s.getJMBAG() == jmbag);
    }

    @Override
    public Optional<Student> editStudent(Student student, String JMBAG) {

       /* int ects = MOCKED_STUDENTS.stream().filter(s -> JMBAG.equals(s.getJMBAG())).findFirst().get().getNumberOfECTS();
        MOCKED_STUDENTS.stream().filter(s -> JMBAG.equals(s.getJMBAG())).findFirst().get().setNumberOfECTS(ects + brojEcts);
        return findStudentByJMBAG(JMBAG);*/
       return null;
    }

    @Override
    public List<Student> findStudentByFirstName(String firstname) {
        return null;
    }

    @Override
    public List<Student> findByCourses_Name(String name) {
        return null;
    }

    private Student mapStudentCommandToStudent(StudentCommand student) {
        return new Student(student.getFirstName(), student.getLastName(), student.getNumberOfECTS(), student.getDateOfBirth(), student.getJMBAG());
    }

    private boolean containsJMBAG(String JMBAG){

        //MOCKED_STUDENTS.stream().forEach(s -> System.out.println(s.getJMBAG()));
        //System.out.println(MOCKED_STUDENTS.stream().filter(s -> s.getJMBAG().equals(JMBAG)).findFirst().isPresent());

        return MOCKED_STUDENTS.stream().filter(s -> s.getJMBAG().equals(JMBAG)).findFirst().isPresent();
    }

}



