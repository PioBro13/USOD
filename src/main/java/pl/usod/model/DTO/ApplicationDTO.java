package pl.usod.model.DTO;

public class ApplicationDTO {
    private Long id;
    private String documentId;
    private String documentTitle;
    private Long userId;

    public ApplicationDTO(Long id, String documentId, String documentTitle, Long userId) {
        this.id = id;
        this.documentId = documentId;
        this.documentTitle = documentTitle;
        this.userId = userId;
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

}
