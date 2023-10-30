package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.usod.model.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject,Long> {
    Subject findSubjectById(Long subjectId);
}
