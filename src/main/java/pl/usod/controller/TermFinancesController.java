package pl.usod.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.TermFinancesDTO;
import pl.usod.model.TermFinances;
import pl.usod.repository.TermFinancesRepository;

import java.util.List;

@RestController
@RequestMapping("/api/termFinances")
public class TermFinancesController {

    @Autowired
    private TermFinancesRepository termFinancesRepository;

    @GetMapping
    public List<TermFinances> getTermFinances(){return termFinancesRepository.findAll();}

    @GetMapping("/{termFinancesId}")
    public ResponseEntity<TermFinancesDTO> getOneTermFinances(@PathVariable Long termFinancesId){
        TermFinances termFinances = termFinancesRepository.findTermFinancesById(termFinancesId);
        TermFinancesDTO termFinancesDTO = new TermFinancesDTO(termFinances.getId(), termFinances.getOverallFinances().getId(),termFinances.getTerm().getId());
        return  ResponseEntity.ok(termFinancesDTO);
    }

    @GetMapping("/addTermFinances")
    @PreAuthorize("hasRole('ADMIN')")
    public String showTermFinancesForm(Model model){
        model.addAttribute("termFinances", new TermFinances());
        return "addTermFinances";
    }

    @PostMapping("/addTermFinances")
    @PreAuthorize("hasRole('ADMIN')")
    public TermFinances newTermFinances(@ModelAttribute TermFinances termFinances){
        termFinancesRepository.save(termFinances);
        return termFinances;
    }

    @PutMapping("/editTermFinances/{termFinancesId}")
    public ResponseEntity<?> editTermFinances(@PathVariable("termFinancesId") TermFinances targetTermFinances, @ModelAttribute TermFinances sourceTermFinances){
        BeanUtils.copyProperties(sourceTermFinances,targetTermFinances);
        return ResponseEntity.ok(termFinancesRepository.save(targetTermFinances));
    }

    @DeleteMapping("/deleteTermFinances/{termFinancesId}")
    public ResponseEntity<String> deleteTermFinances(@PathVariable("termFinancesId") Long termFinancesId){
        termFinancesRepository.deleteById(termFinancesId);
        return ResponseEntity.ok("Financal term summary has been removed. ID: " + termFinancesId);
    }

}
