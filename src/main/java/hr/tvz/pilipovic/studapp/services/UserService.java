package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findByUsername(String username);
}
