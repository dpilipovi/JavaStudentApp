package hr.tvz.pilipovic.studapp.services;

import hr.tvz.pilipovic.studapp.entities.Authority;
import hr.tvz.pilipovic.studapp.entities.User;
import hr.tvz.pilipovic.studapp.entities.UserDTO;
import hr.tvz.pilipovic.studapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<UserDTO> findByUsername(String username) {
       return Optional.of(mapToUserDTO(userRepository.findByUsername(username)));
    }

    private UserDTO mapToUserDTO(final User user)
    {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));

        System.out.println(userDTO.toString());

        return userDTO;
    }
}
