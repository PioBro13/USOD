package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="term_number")
    private int termNumber;

    @ManyToOne
    @JoinColumn(name="overall_results_id")
    @JsonBackReference
    private OverallResults overallResults;

    @OneToMany(mappedBy = "term",  cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<Subject> subjects = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(int termNumber) {
        this.termNumber = termNumber;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public OverallResults getOverallResults() {
        return overallResults;
    }

    public void setOverallResults(OverallResults overallResults) {
        this.overallResults = overallResults;
    }
}
