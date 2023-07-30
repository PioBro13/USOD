package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.usod.model.TermResults;
import pl.usod.repository.TermResultsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/termResults")
public class TermResultsController {
    @Autowired
    private TermResultsRepository termResultsRepository;

    @GetMapping
    public List<TermResults> getTermResults(){
        return termResultsRepository.findAll();
    }

}
