package pl.usod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.usod.model.Application;
import pl.usod.model.DTO.ApplicationDTO;
import pl.usod.repository.ApplicationRepository;
import pl.usod.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    //for alternative deserialization
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Application> getApplications(){
        return applicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Application getOneById(@PathVariable Long id){
        return applicationRepository.findApplicationById(id);
    }

    @GetMapping("/userId={id}")
    public Application getByUser(@PathVariable Long userId){
        return applicationRepository.findByUserId(userId);
    }

//    REQUEST BODY:
//    {
//    "documentId": "abc123",
//    "documentTitle": "abc321",
//    "user": {
//        "id": 1
//    }
//}
    @PostMapping(value = "/addApplication")
    public ResponseEntity<?> addApplication(@RequestBody Application application) {
        try{
            applicationRepository.save(application);
            return  ResponseEntity.ok( "New application added");
        }catch (Exception e){
            return new ResponseEntity<>("Error when new application was added: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    REQUEST BODY:
//    {
//    "documentId": "abc123",
//    "documentTitle": "abc321",
//    "userId": 1
//    }
    @PostMapping(value = "/addApplicationAlt")
    public ResponseEntity<?> addApplicationAlt(@RequestBody ApplicationDTO applicationDTO) {
        ////////////////// THIS SHOULD BE IN SOME MAPPER /////////////////
        return userRepository.findById(applicationDTO.getUserId()).map(user -> {
            Application application = new Application();
            application.setDocumentId(applicationDTO.getDocumentId());
            application.setDocumentTitle(applicationDTO.getDocumentTitle());
            application.setUser(user);
        ///////////////////////////////////////////////////////////////////

            try {
                applicationRepository.save(application);
                return ResponseEntity.ok( "New application added");
            } catch (Exception e){
                return new ResponseEntity<>("Error when new application was added: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }).orElse(new ResponseEntity<>("User not found.", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping("/deleteTerm/{applicationId}")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteApplication(@PathVariable("applicationId") Long applicationId){
        applicationRepository.deleteById(applicationId);
        return ResponseEntity.ok("Application has been removed. ID: " + applicationId);
    }
}
