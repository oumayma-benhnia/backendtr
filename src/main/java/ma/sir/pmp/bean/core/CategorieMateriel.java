package ma.sir.pmp.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "categorie_materiel")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_materiel_seq",sequenceName="categorie_materiel_seq",allocationSize=1, initialValue = 1)
public class CategorieMateriel   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String reference;



    public CategorieMateriel(){
        super();
    }

    public CategorieMateriel(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_materiel_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieMateriel categorieMateriel = (CategorieMateriel) o;
        return id != null && id.equals(categorieMateriel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

