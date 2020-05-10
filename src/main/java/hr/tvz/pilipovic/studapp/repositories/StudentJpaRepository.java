package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import hr.tvz.pilipovic.studapp.services.StudentService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public interface StudentJpaRepository extends JpaRepository<Student, String> {

    Student findStudentByJMBAG(String jmbag);

    @Transactional
    long deleteStudentByJMBAG(String jmbag);

    List<Student> findStudentByFirstName(String firstname);

    Student save(Student student);

   /* @Modifying
    @Query(value = "update students set numberofects = numberofects + :ects where jmbag = :jmbag",nativeQuery = true)
    void editEcts(@Param("ects") int ects, @Param("jmbag") String jmbag);*/

    List<Student> findByCourses_Name(String name);

}
