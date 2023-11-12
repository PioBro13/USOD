package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.usod.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
