package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.OverallResults;

public interface OverallResultsRepository extends JpaRepository<OverallResults,Long> {
}
