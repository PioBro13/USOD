package pl.usod.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "term_finances")
public class TermFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "term_id")
    @JsonBackReference
    private Term term;

    @ManyToOne
    @JoinColumn(name="overall_finances_id")
    @JsonBackReference
    private OverallFinances overallFinances;

    @OneToMany(mappedBy = "termFinances", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OperationFinances> operationFinances = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public OverallFinances getOverallFinances() {
        return overallFinances;
    }

    public void setOverallFinances(OverallFinances overallFinances) {
        this.overallFinances = overallFinances;
    }

    public List<OperationFinances> getOperationFinances() {
        return operationFinances;
    }

    public void setOperationFinances(List<OperationFinances> operationFinances) {
        this.operationFinances = operationFinances;
    }
}
