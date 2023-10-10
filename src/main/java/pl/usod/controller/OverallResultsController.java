package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/addOverallResults")
    public String showOverallResultsForm(Model model){
        model.addAttribute("overallResults",new OverallResults());
        return "addOverallResults";
    }

    @PostMapping("/addOverallResults")
    public OverallResults newOverallResults(@ModelAttribute OverallResults overallResults){
        overallResultsRepository.save(overallResults);
        return overallResults;
    }

}
