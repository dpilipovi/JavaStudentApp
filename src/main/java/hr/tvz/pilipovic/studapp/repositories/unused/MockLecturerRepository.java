/*package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Lecturer;
import hr.tvz.pilipovic.studapp.entities.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MockLecturerRepository implements LecturerRepository {


    private List<Lecturer> MOCKED_LECTURERS = new ArrayList<>(
            Arrays.asList(
                    new Lecturer(0, "Pero", "Peric", "pero.peric@email.com"),
                    new Lecturer(1, "Ivan", "Ivancic", "ivan.ivancic@email.com")
            )
    );

    @Override
    public List<Lecturer> findAll() {
        return MOCKED_LECTURERS;
    }

    @Override
    public Optional<Lecturer> getLecturerById(long id) {
        return MOCKED_LECTURERS.stream().filter(l -> l.getId() == id).findAny();
    }
}*/
