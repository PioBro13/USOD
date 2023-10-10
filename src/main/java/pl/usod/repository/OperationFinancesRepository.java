package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.OperationFinances;

public interface OperationFinancesRepository extends JpaRepository<OperationFinances, Long> {
}
