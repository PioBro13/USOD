package pl.usod.model.DTO;

public class ApplicationDTO {
    private Long id;
    private String documentId;
    private String documentTitle;
    private Long userId;
    private String applicationName;
    private String formName;

    public ApplicationDTO(Long id, String documentId, String documentTitle, Long userId, String applicationName, String formName) {
        this.id = id;
        this.documentId = documentId;
        this.documentTitle = documentTitle;
        this.userId = userId;
        this.applicationName = applicationName;
        this.formName = formName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }
}
