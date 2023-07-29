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

    //TODO link with students table
    @Column(name = "studentId")
    protected Long studentId;

    @Column(name="studentTermNumber")
    private int studentTermNumber;

    @Column(name = "registerType")
    private String registerType;

    @Column(name = "studentGroup")
    private String studentGroup;

    @Column(name="startingECTS")
    private int startingECTS;

    @Column(name = "finalECTS")
    private int finalECTS;

    @Column(name="nominalECTS")
    private int nominalECTS;

    @Column(name = "obtainedECTS")
    private int obtainedECTS;

    @Column(name = "speciality")
    private String speciality;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(int termNumber) {
        this.termNumber = termNumber;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public int getStudentTermNumber() {
        return studentTermNumber;
    }

    public void setStudentTermNumber(int studentTermNumber) {
        this.studentTermNumber = studentTermNumber;
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
}
