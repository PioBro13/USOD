package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.usod.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
