package ma.sir.pmp.zynerator.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditBaseDto extends BaseDto {


    @JsonIgnore
    protected int maxLevel = 2;
    /**
     * created on
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String createdOn;
    /**
     * updated on
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String updatedOn;
    /**
     * created by
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String createdBy;
    /**
     * updated by
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String updatedBy;

    /**
     * Constructeur par défaut.
     */
    public AuditBaseDto() {
    }

    public AuditBaseDto(Long id) {
        super(id);
    }

    /**
     * created date
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     * created date
     *
     * @param createOn
     */
    public void setCreatedOn(String createOn) {
        this.createdOn = createOn;
    }

    /**
     * updated date
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
    public String getUpdatedOn() {
        return updatedOn;
    }

    /**
     * updated date
     *
     * @param updatedOn
     */
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * created user
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
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
