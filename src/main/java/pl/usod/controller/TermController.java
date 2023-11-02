package pl.usod.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.TermDTO;
import pl.usod.model.Subject;
import pl.usod.model.Term;
import pl.usod.model.TermFinances;
import pl.usod.repository.TermRepository;
import java.util.List;

@RestController
@RequestMapping("/api/term")
public class TermController {
    @Autowired
    private TermRepository termRepository;

    @GetMapping
    public List<Term> getTerms(){
        return termRepository.findAll();
    }

    @GetMapping("/{termId}")
    public ResponseEntity<TermDTO> getOneTerm(@PathVariable Long termId){
        Term term = termRepository.findTermById(termId);
        TermDTO termDTO = new TermDTO(term.getId(), term.getTermNumber(), term.getRegisterType(),
                term.getStudentGroup(),term.getStartingECTS(),term.getFinalECTS(),term.getNominalECTS(),
                term.getObtainedECTS(),term.getSpeciality(),term.getOverallResults().getId());
        return ResponseEntity.ok(termDTO);
    }

    @GetMapping("/addTerm")
    public String showTermForm(Model model) {
        model.addAttribute("term", new Term());
        return "addTerm";
    }

    @PostMapping("/addTerm")
    public Term newTerm(@ModelAttribute Term term){
        termRepository.save(term);
        return term;
    }

    @GetMapping("/editTerm/{termId}")
    public String showEditTermForm(@PathVariable Long termId, Model model){
        Term term = termRepository.findById(termId).orElseThrow(() -> new EntityNotFoundException("Term not found. ID: " + termId));
        model.addAttribute("term",term);
        return "editTerm";
    }

    @PutMapping("/editTerm/{termId}")
    public ResponseEntity<?> editTerm(@PathVariable("termId") Term targetTerm, @ModelAttribute Term sourceTerm){
        BeanUtils.copyProperties(sourceTerm,targetTerm);
        return ResponseEntity.ok(termRepository.save(targetTerm));
    }

    @DeleteMapping("/deleteTerm/{termId}")
    public ResponseEntity<String> deleteTerm(@PathVariable("termId") Long termId){
        termRepository.deleteById(termId);
        return ResponseEntity.ok("Term has been removed. ID: " + termId);
    }


}
