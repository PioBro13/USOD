package pl.usod.model.DTO;

public class TermDTO {
    private Long id;
    private int termNumber;
    private String registerType;
    private String studentGroup;
    private int startingECTS;
    private int finalECTS;
    private int nominalECTS;
    private int obtainedECTS;
    private String speciality;
    private Long overallResultsId;

    public TermDTO(Long id, int termNumber, String registerType, String studentGroup, int startingECTS, int finalECTS, int nominalECTS, int obtainedECTS, String speciality, Long overallResultsId) {
        this.id = id;
        this.termNumber = termNumber;
        this.registerType = registerType;
        this.studentGroup = studentGroup;
        this.startingECTS = startingECTS;
        this.finalECTS = finalECTS;
        this.nominalECTS = nominalECTS;
        this.obtainedECTS = obtainedECTS;
        this.speciality = speciality;
        this.overallResultsId = overallResultsId;
    }

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

    public Long getOverallResultsId() {
        return overallResultsId;
    }

    public void setOverallResultsId(Long overallResultsId) {
        this.overallResultsId = overallResultsId;
    }
}
