package ma.sir.pmp.zynerator.audit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import ma.sir.pmp.zynerator.bean.BusinessObject;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Classe mère abstraite de tous les Objets métier.
 *
 * @author JAF
 * @version 1.2
 */

@MappedSuperclass
@EntityListeners(EntityListener.class)
public class AuditBusinessObject extends BusinessObject {

    /**
     * created on
     */
    private LocalDateTime createdOn;

    /**
     * updated on
     */
    private LocalDateTime updatedOn;

    /**
     * created by
     */
    private String createdBy;

    /**
     * updated by
     */
    private String updatedBy;

    /**
     * Constructeur par défaut.
     */
    public AuditBusinessObject() {
        super();
    }

    public AuditBusinessObject(Long id) {
        super(id);
    }

    /**
     * created date
     *
     * @return LocalDateTime
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "createdon", updatable = false)
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    /**
     * created date
     *
     * @param createOn
     */
    public void setCreatedOn(LocalDateTime createOn) {
        this.createdOn = createOn;
    }

    /**
     * updated date
     *
     * @return LocalDateTime
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "updatedon")
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    /**
     * updated date
     *
     * @param updatedOn
     */
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * created user
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "createdby", updatable = false)
    public String getCreatedBy() {
        return createdBy != null ? createdBy : "";
    }

    /**
     * created user
     *
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * updated user
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "updatedby")
    public String getUpdatedBy() {
        return updatedBy != null ? updatedBy : "";
    }

    /**
     * updated user
     *
     * @param UpdatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
