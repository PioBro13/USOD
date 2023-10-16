package pl.usod.model.DTO;

public class OperationFinancesDTO {
    private Long id;
    private String operationName;
    private double value;
    private String description;
    private Long termFinances;

    public OperationFinancesDTO(Long id, String operationName, double value, String description, Long termFinances) {
        this.id = id;
        this.operationName = operationName;
        this.value = value;
        this.description = description;
        this.termFinances = termFinances;
    }

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

    public Long getTermFinances() {
        return termFinances;
    }

    public void setTermFinances(Long termFinances) {
        this.termFinances = termFinances;
    }
}
