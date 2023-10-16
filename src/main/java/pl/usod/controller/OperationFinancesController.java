package pl.usod.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.OperationFinancesDTO;
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
    public ResponseEntity<OperationFinancesDTO> getOneOperationFinances(@PathVariable Long operationFinancesId){
        OperationFinances operationFinances = operationFinancesRepository.findOperationFinancesById(operationFinancesId);

        OperationFinancesDTO operationFinancesDTO = new OperationFinancesDTO(operationFinances.getId(),operationFinances.getOperationName(),
                operationFinances.getValue(),operationFinances.getDescription(), operationFinances.getTermFinances().getId()
        );

        return ResponseEntity.ok(operationFinancesDTO);
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

    @PutMapping("/editOperationFinaces/{operationFinancesId}")
    public ResponseEntity<?> editOperationFinances(@PathVariable("operationFinancesId") OperationFinances targetOperationFinances, @ModelAttribute OperationFinances sourceOperationFinances){
        BeanUtils.copyProperties(sourceOperationFinances , targetOperationFinances, "id" );
        return ResponseEntity.ok(operationFinancesRepository.save(targetOperationFinances));
    }

}
