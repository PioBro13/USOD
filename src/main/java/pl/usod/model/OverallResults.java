package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "overall_results")
public class OverallResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "term_id")
    private int termId;


    @Column(name="student_term_number")
    private int studentTermNumber;

    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;


    @OneToMany(mappedBy = "overallResults", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Term> terms = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }


    public int getStudentTermNumber() {
        return studentTermNumber;
    }

    public void setStudentTermNumber(int studentTermNumber) {
        this.studentTermNumber = studentTermNumber;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }
}
