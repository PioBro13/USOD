package pl.usod.model.DTO;

public class TermFinancesDTO {
    private Long id;
    private Long overallFinances;
    private Long term;

    public TermFinancesDTO(Long id, Long overallFinances, Long term) {
        this.id = id;
        this.overallFinances = overallFinances;
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOverallFinances() {
        return overallFinances;
    }

    public void setOverallFinances(Long overallFinances) {
        this.overallFinances = overallFinances;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }
}
