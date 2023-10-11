package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public OverallFinances getOneOverallFinances(@PathVariable Long overallFinancesId){
        return overallFinancesRepository.findOverallFinancesById(overallFinancesId);
    }

    @GetMapping("/addOverallFinances")
    public String showOverallFinancesForm(Model model){
        model.addAttribute("overallFinances", new OverallFinances());
        return "addOverallFinances";
    }

    @PostMapping("/addOverallFinances")
    public OverallFinances newOverallFinances(@ModelAttribute OverallFinances overallFinances){
        overallFinancesRepository.save(overallFinances);
        return overallFinances;
    }



}
