package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.usod.model.OverallResults;
import pl.usod.repository.OverallResultsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/overallResults")
public class OverallResultsController {
    @Autowired
    private OverallResultsRepository overallResultsRepository;

    @GetMapping
    public List<OverallResults> getOverallResults(){
        return overallResultsRepository.findAll();
    }

    @GetMapping("/{id}")
    public OverallResults getOne(@PathVariable Long id){
        return overallResultsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There are no term results with given id"));
    }

    @GetMapping("/studentId={studentId}")
    public OverallResults getByStudent(@PathVariable Long studentId){
        return overallResultsRepository.findByStudentId(studentId);
    }
}
