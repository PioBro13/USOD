package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.OverallFinances;

public interface OverallFinancesRepository extends JpaRepository<OverallFinances , Long> {
}
