package pl.usod.model;

import jakarta.persistence.*;

@Entity
@Table(name = "termResults")
public class TermResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "termId")
    private int termNumber;

    @Column(name = "studentId")
    protected Long studentId;

    @Column(name="studentTermNumber")
    private int studentTermNumber;

    @Column(name = "registerType")
    private String registerType;

    @Column(name = "studentGroup")
    private String studentGroup;

    @Column(name="")



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
