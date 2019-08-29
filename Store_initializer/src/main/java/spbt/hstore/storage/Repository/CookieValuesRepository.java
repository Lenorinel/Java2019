package spbt.hstore.storage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spbt.hstore.storage.models.CookieValue;
import spbt.hstore.storage.models.User;

import java.util.Optional;

public interface CookieValuesRepository extends JpaRepository<CookieValue, Long> {
    Optional<CookieValue> findByValue(String value);
    void deleteAllByUser(User user);
}
