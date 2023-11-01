package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.TermDTO;
import pl.usod.model.Term;
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
                term.getObtainedECTS(),term.getSpeciality(),term.getOverallResults().getId(),
                term.getTermFinances().getId());
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


}
