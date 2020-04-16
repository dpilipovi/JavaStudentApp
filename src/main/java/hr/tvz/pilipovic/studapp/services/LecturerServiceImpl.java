package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Lecturer;
import hr.tvz.pilipovic.studapp.repositories.LecturerRepository;
import hr.tvz.pilipovic.studapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerServiceImpl implements  LecturerService{

    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public Optional<Lecturer> getLecturerById(long id) {
        return lecturerRepository.getLecturerById(id);
    }

    @Override
    public List<Lecturer> getLecturers() {
       return lecturerRepository.findAll();
    }
}
