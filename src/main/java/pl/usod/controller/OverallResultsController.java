package pl.usod.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.OverallResultsDTO;
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
    public ResponseEntity<OverallResultsDTO> getOne(@PathVariable Long id){
        OverallResults overallResults = overallResultsRepository.findOverallResultsById(id);
        OverallResultsDTO overallResultsDTO = new OverallResultsDTO(overallResults.getId(), overallResults.getStudent().getId());
        return ResponseEntity.ok(overallResultsDTO);
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

    @PutMapping("/editOverallResults/{overallResultsId}")
    public ResponseEntity<?> editOverallResults(@PathVariable("overallResultsId") OverallResults targetOverallResults, @ModelAttribute OverallResults sourceOverallResults){
        BeanUtils.copyProperties(sourceOverallResults,targetOverallResults);
        return ResponseEntity.ok(overallResultsRepository.save(targetOverallResults));
    }

    @DeleteMapping("/deleteOverallResults/{overallResultsId}")
    public ResponseEntity<String> deleteTerm(@PathVariable("overallResultsId") Long overallResultsId){
        overallResultsRepository.deleteById(overallResultsId);
        return ResponseEntity.ok("Overall results has been removed. ID: " + overallResultsId);
    }

}
