package pl.usod.controller;

import jakarta.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
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

}
