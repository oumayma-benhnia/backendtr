package ma.sir.pmp.zynerator.dto;

import ma.sir.pmp.zynerator.history.HistBusinessObject;
import ma.sir.pmp.zynerator.util.DateUtil;

public class AuditEntityDto extends BaseDto {

    /**
     * Colonne
     */
    private String objectName;

    /**
     * OldValue
     */
    private String data;

    /**
     * UserId
     */
    private Long userId;

    /**
     * Username
     */
    private String username;

    /**
     * Type_action
     */
    private String actionType;

    /**
     * ObjectId
     */
    private Long objectId;

    private String date;

    public AuditEntityDto() {

    }

    public AuditEntityDto(Long id) {
        super(id);
    }

    public <T extends HistBusinessObject> AuditEntityDto(T histBusinessObject) {
        super();
        convertToDto(this, histBusinessObject);
    }

    public <T extends HistBusinessObject> AuditEntityDto convertToDto(AuditEntityDto auditEntityDto, T histBusinessObject) {
        if (auditEntityDto != null) {
            auditEntityDto.setId(histBusinessObject.getId());
            auditEntityDto.setObjectName(histBusinessObject.getObjectName());
            auditEntityDto.setDate(DateUtil.dateTimeToString(histBusinessObject.getDate()));
            auditEntityDto.setObjectId(histBusinessObject.getObjectId());
            auditEntityDto.setActionType(histBusinessObject.getActionType());
            auditEntityDto.setData(histBusinessObject.getData());
            auditEntityDto.setUserId(histBusinessObject.getUserId());
            auditEntityDto.setUsername(histBusinessObject.getUsername());
        }

        return auditEntityDto;

    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}