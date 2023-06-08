package ma.sir.pmp.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "materiel")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="materiel_seq",sequenceName="materiel_seq",allocationSize=1, initialValue = 1)
public class Materiel   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String quantite;
    private BigDecimal prix = BigDecimal.ZERO;

    private CategorieMateriel categorieMateriel ;
    


    public Materiel(){
        super();
    }

    public Materiel(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="materiel_seq")
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
    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CategorieMateriel getCategorieMateriel(){
        return this.categorieMateriel;
    }
    public void setCategorieMateriel(CategorieMateriel categorieMateriel){
        this.categorieMateriel = categorieMateriel;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
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
        Materiel materiel = (Materiel) o;
        return id != null && id.equals(materiel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

