package pl.usod.controller;

import jakarta.jws.WebParam;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.DTO.SubjectDTO;
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
    public ResponseEntity<SubjectDTO> getOneSubject(@PathVariable Long subjectId){
        Subject subject = subjectRepository.findSubjectById(subjectId);
        SubjectDTO subjectDTO = new SubjectDTO(subject.getId(),subject.getSubjectName(),subject.getExam(),
                subject.getStudentTermNumber(),subject.getEctsNumber(),subject.getInstructor(),subject.getGrade(),
                subject.getTerm().getId());
        return ResponseEntity.ok(subjectDTO);
    }

    @GetMapping("/addSubject")
    @PreAuthorize("hasRole('ADMIN')")
    public String showSubjectForm(Model model){
        model.addAttribute("subject", new Subject());
        return "addSubject";
    }

    @PostMapping("/addSubject")
    @PreAuthorize("hasRole('ADMIN')")
    public Subject newSubject(@ModelAttribute Subject subject){
        subjectRepository.save(subject);
        return subject;
    }

    @GetMapping("/editSubject/{subjectId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditSubjectForm(@PathVariable Long subjectId, Model model){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()
                -> new EntityNotFoundException("Subject not found. ID: " + subjectId));
        model.addAttribute("subject",subject);
        return "editSubject";
    }

    @PutMapping("/editSubject/{subjectId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editSubject(@PathVariable("subjectId") Subject targetSubject, @ModelAttribute Subject sourceSubject){
        BeanUtils.copyProperties(sourceSubject,targetSubject,"id");
        return ResponseEntity.ok(subjectRepository.save(targetSubject));
    }

    @DeleteMapping("/deleteSubject/{subjectId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteSubject(@PathVariable("subjectId") Long subjectId){
        subjectRepository.deleteById(subjectId);
        return ResponseEntity.ok("Subject has been removed. ID: " + subjectId);
    }

}
