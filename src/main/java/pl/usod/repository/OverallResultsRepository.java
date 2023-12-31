package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.OverallResults;

import java.util.List;

public interface OverallResultsRepository extends JpaRepository<OverallResults,Long> {

    OverallResults findByUserId(Long userId);
    OverallResults findOverallResultsById(Long overallResultsId);
}
