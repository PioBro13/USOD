package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "operation_finances")
public class OperationFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="operation_name")
    private String operationName;

    @Column(name="value")
    private double value;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="term_finances_id")
    @JsonBackReference
    private TermFinances termFinances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TermFinances getTermFinances() {
        return termFinances;
    }

    public void setTermFinances(TermFinances termFinances) {
        this.termFinances = termFinances;
    }
}
