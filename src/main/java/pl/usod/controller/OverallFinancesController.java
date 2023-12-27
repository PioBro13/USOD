package pl.usod.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.OverallFinancesDTO;
import pl.usod.model.OverallFinances;
import pl.usod.repository.OverallFinancesRepository;

import java.util.List;

@RestController
@RequestMapping("/api/overallFinances")
public class OverallFinancesController {

    @Autowired
    private OverallFinancesRepository overallFinancesRepository;

    @GetMapping
    public List<OverallFinances> getOverallFinances(){return overallFinancesRepository.findAll();}

    @GetMapping("/{overallFinancesId}")
    public ResponseEntity<OverallFinancesDTO> getOneOverallFinances(@PathVariable Long overallFinancesId){
        OverallFinances overallFinances = overallFinancesRepository.findOverallFinancesById(overallFinancesId);
        OverallFinancesDTO overallFinancesDTO = new OverallFinancesDTO(overallFinances.getId(), overallFinances.getUser().getId());
        return ResponseEntity.ok(overallFinancesDTO);
    }

    @GetMapping("/addOverallFinances")
    @PreAuthorize("hasRole('ADMIN')")
    public String showOverallFinancesForm(Model model){
        model.addAttribute("overallFinances", new OverallFinances());
        return "addOverallFinances";
    }

    @PostMapping("/addOverallFinances")
    @PreAuthorize("hasRole('ADMIN')")
    public OverallFinances newOverallFinances(@ModelAttribute OverallFinances overallFinances){
        overallFinancesRepository.save(overallFinances);
        return overallFinances;
    }

    @PutMapping("/editOverallFinances/{overallFinancesId}")
    public ResponseEntity<?> editOverallFinances(@PathVariable("overallFinancesId") OverallFinances targetOverallFinances, @ModelAttribute OverallFinances sourceOverallFinances){
        BeanUtils.copyProperties(sourceOverallFinances,targetOverallFinances);
        return ResponseEntity.ok(overallFinancesRepository.save(targetOverallFinances));
    }

    @DeleteMapping("/deleteOverallFinances/{overallFinancesId}")
    public ResponseEntity<String> deleteTerm(@PathVariable("overallFinancesId") Long overallFinancesId){
        overallFinancesRepository.deleteById(overallFinancesId);
        return ResponseEntity.ok("Overall finances has been removed. ID: " + overallFinancesId);
    }


}
