package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.Lecturer;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository {

    List<Lecturer> findAll();

    Optional<Lecturer> getLecturerById(long id);
}
