package pl.usod.model;

import jakarta.persistence.*;

@Entity
@Table(name = "overall_results")
public class OverallResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "term_id")
    private int termId;

    //TODO link with students table


    @Column(name="student_term_number")
    private int studentTermNumber;

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

    @OneToOne
    private Student student;



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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
