package ma.sir.pmp.zynerator.bean;

import javax.persistence.Transient;
import java.io.Serializable;


/**
 * Classe mère abstraite de tous les Objets métier.
 *
 * @author JAF
 * @version 1.2
 */
public class BusinessObject implements Serializable {

    protected Long id;
    protected String label;
    protected Etablissement etablissement;

    /**
     * Constructeur par défaut.
     */
    public BusinessObject() {
    }

    public BusinessObject(Long id) {
        this.id = id;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    /**
     * Méthode de test de l'égalité entre deux objets métier. Ils sont
     * identiques si leurs clés primaires sont identiques et qu'ils sont de la
     * mème classe (plusieurs objets peuvent avoir la mème clé primaire).
     */
    @Override
    public boolean equals(Object object) {
        if (this.id != null && object instanceof BusinessObject) {
            BusinessObject businessObject = (BusinessObject) object;
            return this.id.equals(businessObject.getId());
        }
        return false;

    }

    /**
     * Méthode hashCode.
     *
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        Serializable pk = id;
        if (pk == null) {
            return 0;
        }
        return pk.toString().hashCode();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getLabel() {
        label = id != null ? id.toString() : null;
        return label;
    }

    public String toString() {

        return this.getId() != null ? this.getId().toString() : null;
    }

}
