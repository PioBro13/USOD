package pl.usod.model;

import jakarta.persistence.*;

import java.awt.*;
import java.util.List;

@Entity
@Table(name="term_subject")
public class TermSubjectJunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Subject> subjectList;

    @OneToMany
    private List<Term> TermList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Term> getTermList() {
        return TermList;
    }

    public void setTermList(List<Term> termList) {
        TermList = termList;
    }
}
