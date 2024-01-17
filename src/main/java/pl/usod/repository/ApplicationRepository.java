package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.Application;

public interface ApplicationRepository extends JpaRepository<Application , Long> {
    Application findApplicationById(Long applicationId);
    Application findByUserId(Long userId);


}
