package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.usod.model.TermSubjectJunction;

@Repository
public interface TermSubjectJunctionRepository extends JpaRepository<TermSubjectJunction,Long> {
}
