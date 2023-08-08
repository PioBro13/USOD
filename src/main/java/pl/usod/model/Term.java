package pl.usod.model;

import jakarta.persistence.*;

@Entity
@Table(name = "term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="term_number")
    private int termNumber;


    // TODO link to junction table
    @Column(name = "subject")
    private String subject;

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
}
