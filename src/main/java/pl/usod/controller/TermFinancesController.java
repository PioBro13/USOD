package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
