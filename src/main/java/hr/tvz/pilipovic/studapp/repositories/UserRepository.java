package hr.tvz.pilipovic.studapp.repositories;

import hr.tvz.pilipovic.studapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findOneByUsername(String username);
}
