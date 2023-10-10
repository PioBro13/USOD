package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.TermFinances;

public interface TermFinancesRepository extends JpaRepository<TermFinances, Long> {
}
