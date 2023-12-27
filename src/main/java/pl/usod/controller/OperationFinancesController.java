package pl.usod.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public String showOperationFinacesForm(Model model){
        model.addAttribute("operationFinaces", new OperationFinances());
        return "addOperationFinances";
    }

    @PostMapping("/addOperationFinances")
    @PreAuthorize("hasRole('ADMIN')")
    public OperationFinances addOperationFinances(@ModelAttribute OperationFinances operationFinances){
        operationFinancesRepository.save(operationFinances);
        return operationFinances;
    }

    @GetMapping("/editOperationFinances/{operationFinancesId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditOperationFinacesForm(@PathVariable Long operationFinancesId, Model model) {
        OperationFinances operationFinances = operationFinancesRepository.findById(operationFinancesId).orElseThrow(() -> new EntityNotFoundException("Nie znaleziono operacji finansowej o podanym ID: " + operationFinancesId));
        model.addAttribute("operationFinances", operationFinances);
        return "editOperationFinances";
    }

    @PutMapping("/editOperationFinances/{operationFinancesId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editOperationFinances(@PathVariable("operationFinancesId") OperationFinances targetOperationFinances, @ModelAttribute OperationFinances sourceOperationFinances){
        BeanUtils.copyProperties(sourceOperationFinances , targetOperationFinances, "id" );
        return ResponseEntity.ok(operationFinancesRepository.save(targetOperationFinances));
    }

    @DeleteMapping("/deleteOperationFinances/{operationFinancesId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteOperationFinances(@PathVariable("operationFinancesId") Long id){
        operationFinancesRepository.deleteById(id);
        return  ResponseEntity.ok("Operation finances has been removed. Id: " + id);
    }

}
