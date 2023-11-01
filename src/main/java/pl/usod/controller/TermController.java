package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public Term getOneTerm(@PathVariable Long termId){
        return  termRepository.findById(termId)
                .orElseThrow(() -> new RuntimeException("no term with given id"));
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
