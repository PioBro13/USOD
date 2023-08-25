package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



}
