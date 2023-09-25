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

    @Column(name = "register_type")
    private String registerType;

    @Column(name = "student_group")
    private String studentGroup;

    @Column(name="starting_ects")
    private int startingECTS;

    @Column(name = "final_ects")
    private int finalECTS;

    @Column(name="nominal_ects")
    private int nominalECTS;

    @Column(name = "obtained_ects")
    private int obtainedECTS;

    @Column(name = "speciality")
    private String speciality;

    @ManyToOne
    @JoinColumn(name="overall_results_id")
    @JsonBackReference
    private OverallResults overallResults;

    @OneToMany(mappedBy = "term",  cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<Subject> subjects = new ArrayList<>();

    @OneToOne(mappedBy = "term")
    @JsonManagedReference
    private TermFinances termFinances;

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
    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getStartingECTS() {
        return startingECTS;
    }

    public void setStartingECTS(int startingECTS) {
        this.startingECTS = startingECTS;
    }

    public int getFinalECTS() {
        return finalECTS;
    }

    public void setFinalECTS(int finalECTS) {
        this.finalECTS = finalECTS;
    }

    public int getNominalECTS() {
        return nominalECTS;
    }

    public void setNominalECTS(int nominalECTS) {
        this.nominalECTS = nominalECTS;
    }

    public int getObtainedECTS() {
        return obtainedECTS;
    }

    public void setObtainedECTS(int obtainedECTS) {
        this.obtainedECTS = obtainedECTS;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public TermFinances getTermFinances() {
        return termFinances;
    }

    public void setTermFinances(TermFinances termFinances) {
        this.termFinances = termFinances;
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
