package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
