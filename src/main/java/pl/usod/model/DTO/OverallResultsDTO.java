package pl.usod.model.DTO;

public class OverallResultsDTO {
    private Long id;
    private Long student;

    public OverallResultsDTO(Long id, Long student) {
        this.id = id;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }
}
