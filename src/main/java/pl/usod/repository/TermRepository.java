package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.usod.model.Term;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
}
