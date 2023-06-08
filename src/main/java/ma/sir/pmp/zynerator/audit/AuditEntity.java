package ma.sir.pmp.zynerator.audit;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditEntity implements Serializable {

    /**
     * Colonne
     */
    private String colonne;

    /**
     * OldValue
     */
    private String oldValue;

    /**
     * OldValueFormat
     */
    private String oldValueFormat;

    /**
     * NewValue
     */
    private String newValue;

    /**
     * NewValueFormat
     */
    private String newValueFormat;

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
    private String typeaction;

    /**
     * ObjectId
     */
    private Long objectId;

    /**
     * Date
     */
    private transient LocalDateTime dateTime;

    /**
     * is Enum
     */
    private boolean enume;

    public String getColonne() {
        return this.colonne;
    }

    public void setColonne(String colonne) {
        this.colonne = colonne;
    }

    public String getOldValue() {
        return this.oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getOldValueFormat() {
        return this.oldValueFormat;
    }

    public void setOldValueFormat(String oldValueFormat) {
        this.oldValueFormat = oldValueFormat;
    }

    public String getNewValue() {
        return this.newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getNewValueFormat() {
        return this.newValueFormat;
    }

    public void setNewValueFormat(String newValueFormat) {
        this.newValueFormat = newValueFormat;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTypeaction() {
        return this.typeaction;
    }

    public void setTypeaction(String typeaction) {
        this.typeaction = typeaction;
    }

    public Long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isEnume() {
        return this.enume;
    }

    public void setEnume(boolean enume) {
        this.enume = enume;
    }

}