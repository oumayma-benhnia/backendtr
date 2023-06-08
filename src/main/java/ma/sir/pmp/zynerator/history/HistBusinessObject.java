package ma.sir.pmp.zynerator.history;

import ma.sir.pmp.zynerator.bean.BusinessObject;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Classe mère abstraite de tous les Objets métier.
 *
 * @author JAF
 * @version 1.2
 */

@MappedSuperclass
public class HistBusinessObject extends BusinessObject {

    /**
     * ObjectName
     */
    private String objectName;

    /**
     * data
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

    /**
     * Date
     */
    private LocalDateTime date;

    /**
     * Constructeur par défaut.
     */
    public HistBusinessObject() {
        super();
    }

    public HistBusinessObject(Long id) {
        super(id);
        this.id = id;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String toString() {

        return this.getId() != null ? this.getId().toString() : null;
    }

}
