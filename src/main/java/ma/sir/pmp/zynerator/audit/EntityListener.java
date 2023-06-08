package ma.sir.pmp.zynerator.audit;

import ma.sir.pmp.zynerator.security.bean.User;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

public class EntityListener implements Serializable {

    @PrePersist
    public void prePersist(AuditBusinessObject auditBusinessObject) {

        if (auditBusinessObject.getCreatedOn() == null) {
            auditBusinessObject.setCreatedOn(LocalDateTime.now());
            auditBusinessObject.setCreatedBy(getCurrentUser());
        }
    }

    @PreUpdate
    public void preUpdate(AuditBusinessObject auditBusinessObject) {
        auditBusinessObject.setUpdatedOn(LocalDateTime.now());
        auditBusinessObject.setUpdatedBy(getCurrentUser());
    }

    public String getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (currentUser != null && currentUser instanceof String) {
                return (String) currentUser;
            } else if (currentUser != null && currentUser instanceof User) {
                return ((User) currentUser).getNom();
            } else return null;
        }

        return null;
    }

}