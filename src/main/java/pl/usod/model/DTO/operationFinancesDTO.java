package pl.usod.model.DTO;

public class operationFinancesDTO {
    private Long id;
    private String operationName;
    private double value;
    private String description;
    private Long termFinancesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTermFinancesId() {
        return termFinancesId;
    }

    public void setTermFinancesId(Long termFinancesId) {
        this.termFinancesId = termFinancesId;
    }
}
