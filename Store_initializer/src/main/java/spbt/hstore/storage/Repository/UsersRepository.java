package spbt.hstore.storage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spbt.hstore.storage.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByLogin(String login);
    //List<User> findAllByOrderByCountDesc(); Для кастомера
}
