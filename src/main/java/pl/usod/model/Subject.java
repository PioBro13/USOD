package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_name")
    private String subjectName;

    @Column(name="exam")
    private boolean exam;

    @Column(name="student_term_number")
    private int studentTermNumber;

    @Column(name = "ects_number")
    private int ectsNumber;

    @Column(name = "instructor")
    private String instructor;

    @Column(name="grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name="term_id")
    @JsonBackReference
    private Term term;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean getExam() {
        return exam;
    }

    public void setExam(boolean exam) {
        this.exam = exam;
    }

    public int getStudentTermNumber() {
        return studentTermNumber;
    }

    public void setStudentTermNumber(int studentTermNumber) {
        this.studentTermNumber = studentTermNumber;
    }

    public int getEctsNumber() {
        return ectsNumber;
    }

    public void setEctsNumber(int ectsNumber) {
        this.ectsNumber = ectsNumber;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Term getTerm() {
        return term;
    }

    public void setTermId(Term term) {
        this.term = term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
}
