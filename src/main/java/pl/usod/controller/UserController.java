package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.User;
import pl.usod.repository.UserRepository;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public User getOne(@RequestParam Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no student with given id"));
    }

    @GetMapping("/addUser")
    public String showUserForm(Model model){
        model.addAttribute("student", new User());
        return "addStudent";
    }

    @PostMapping("/addUser")
    public User newStudent(@ModelAttribute User user){
        userRepository.save(user);
        return user;
    }

}
