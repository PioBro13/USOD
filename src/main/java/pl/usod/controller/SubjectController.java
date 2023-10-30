package pl.usod.controller;

import jakarta.jws.WebParam;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.Subject;
import pl.usod.repository.SubjectRepository;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    @GetMapping("/{subjectId}")
    public Subject getOneSubject(@PathVariable Long subjectId){
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("no subject with given id"));
    }

    @GetMapping("/addSubject")
    public String showSubjectForm(Model model){
        model.addAttribute("subject", new Subject());
        return "addSubject";
    }

    @PostMapping("/addSubject")
    public Subject newSubject(@ModelAttribute Subject subject){
        subjectRepository.save(subject);
        return subject;
    }

    @GetMapping("/editSubject/{subjectId}")
    public String showEditSubjectForm(@PathVariable Long subjectId, Model model){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new EntityNotFoundException("Nie znaleziono przedmiotu o podanym ID: " + subjectId));
        model.addAttribute("subject",subject);
        return "editSubject";
    }

    @PutMapping("/editSubject/{subjectId}")
    public ResponseEntity<?> editSubject(@PathVariable("subjectId") Subject targetSubject, @ModelAttribute Subject sourceSubject){
        BeanUtils.copyProperties(sourceSubject,targetSubject,"id");
        return ResponseEntity.ok(subjectRepository.save(targetSubject));
    }

}
