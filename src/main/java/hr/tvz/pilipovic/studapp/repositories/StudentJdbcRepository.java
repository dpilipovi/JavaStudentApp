package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class StudentJdbcRepository implements StudentRepository {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert studentInserter;


    public StudentJdbcRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.studentInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Students")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Student> findAll() {
        return jdbc.query("select  firstname, lastname, jmbag, numberOfEcts, dateOfBirth from students",
                this::mapRowToStudent);
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return Optional.of((jdbc.queryForObject("SELECT * FROM STUDENTS WHERE JMBAG = ?", new Object[]{JMBAG},this::mapRowToStudent)));
    }

    @Override
    public Optional<Student> save(StudentCommand student) {

        Student s = new Student(student.getFirstName(),student.getLastName(),student.getNumberOfECTS(),student.getDateOfBirth(),student.getJMBAG());
        Map<String, Object> values = new HashMap<>();
        values.put("firstname", student.getFirstName());
        values.put("lastname", student.getLastName());
        values.put("jmbag", student.getJMBAG());
        values.put("dateOfBirth", student.getDateOfBirth());
        values.put("numberOfEcts", student.getNumberOfECTS());

        studentInserter.execute(values);


        return Optional.of(s);
    }

    @Override
    public boolean deleteByJMBAG(String jmbag) {
        jdbc.update("delete from students where jmbag = ?", jmbag);
        return true;
    }

    @Override
    public Optional<Student> editEcts(int brojEcts, String JMBAG) {
        jdbc.update("update students set numberOfEcts = numberOfEcts + ? where jmbag = ?", brojEcts, JMBAG);
        return findStudentByJMBAG(JMBAG);
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setJMBAG(rs.getString("jmbag"));
        student.setFirstName(rs.getString("firstname"));
        student.setLastName(rs.getString("lastname"));
        student.setNumberOfECTS(rs.getInt("numberOfEcts"));
        student.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());

        return student;
    }
}
