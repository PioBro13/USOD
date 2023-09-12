package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "overall_finances")
public class OverallFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @OneToMany(mappedBy = "overallFinances", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TermFinances> termsFinances = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<TermFinances> getTermsFinances() {
        return termsFinances;
    }

    public void setTermsFinances(List<TermFinances> termsFinances) {
        this.termsFinances = termsFinances;
    }
}