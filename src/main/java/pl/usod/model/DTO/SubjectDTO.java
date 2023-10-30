package pl.usod.model.DTO;

public class SubjectDTO {
    private Long id;
    private String subjectName;
    private boolean exam;
    private int studentTermNumber;
    private int ectsNumber;
    private String instructor;
    private int grade;
    private Long termId;

    public SubjectDTO(Long id, String subjectName, boolean exam, int studentTermNumber, int ectsNumber, String instructor, int grade, Long termId) {
        this.id = id;
        this.subjectName = subjectName;
        this.exam = exam;
        this.studentTermNumber = studentTermNumber;
        this.ectsNumber = ectsNumber;
        this.instructor = instructor;
        this.grade = grade;
        this.termId = termId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean isExam() {
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

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }
}
