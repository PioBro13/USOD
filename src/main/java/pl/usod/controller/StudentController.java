package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.Student;
import pl.usod.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no student with given id"));
    }

    @GetMapping("/addStudent")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public Student newStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return student;
    }

}
