package pl.usod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.usod.model.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application , Long> {
    Application findApplicationById(Long applicationId);
    List<Application> findByUserId(Long userId);


}
