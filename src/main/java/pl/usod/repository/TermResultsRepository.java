package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.TermResults;

public interface TermResultsRepository extends JpaRepository<TermResults,Long> {
}
