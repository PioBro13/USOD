package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.OperationFinances;
import pl.usod.repository.OperationFinancesRepository;

import java.util.List;

@RestController
@RequestMapping("/api/operationFinances")
public class OperationFinancesController {

    @Autowired
    private OperationFinancesRepository operationFinancesRepository;

    @GetMapping
    public List<OperationFinances> getOperationFinances(){return operationFinancesRepository.findAll();}

    @GetMapping("/{operationFinancesId}")
    public OperationFinances getOneOperationFinances(@PathVariable Long operationFinancesId){
        return  operationFinancesRepository.findOperationFinancesById(operationFinancesId);
    }

    @GetMapping("/addOperationFinances")
    public String showOperationFinacesForm(Model model){
        model.addAttribute("operationFinaces", new OperationFinances());
        return "addOperationFinances";
    }

    @PostMapping("/addOperationFinances")
    public OperationFinances addOperationFinances(@ModelAttribute OperationFinances operationFinances){
        operationFinancesRepository.save(operationFinances);
        return operationFinances;
    }

}
