package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.OverallResults;

import java.util.List;

public interface OverallResultsRepository extends JpaRepository<OverallResults,Long> {

    OverallResults findByStudentId(Long studentId);
    OverallResults findOverallResultsById(Long overallResultsId);
}
