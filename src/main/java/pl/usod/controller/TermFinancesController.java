package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public TermFinances getOneTermFinances(@PathVariable Long termFinancesId){
        return  termFinancesRepository.findTermFinancesById(termFinancesId);
    }

    @GetMapping("/addTermFinances")
    public String showTermFinancesForm(Model model){
        model.addAttribute("termFinances", new TermFinances());
        return "addTermFinances";
    }

    @PostMapping("/addTermFinances")
    public TermFinances newTermFinances(@ModelAttribute TermFinances termFinances){
        termFinancesRepository.save(termFinances);
        return termFinances;
    }
}
