package ma.sir.pmp.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "projet_ressource")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="projet_ressource_seq",sequenceName="projet_ressource_seq",allocationSize=1, initialValue = 1)
public class ProjetRessource   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal prix = BigDecimal.ZERO;
    @Column(length = 500)
    private String quantite;

    private Ressource ressource ;
    
    private Projet projet ;
    


    public ProjetRessource(){
        super();
    }

    public ProjetRessource(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="projet_ressource_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Ressource getRessource(){
        return this.ressource;
    }
    public void setRessource(Ressource ressource){
        this.ressource = ressource;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }
    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Projet getProjet(){
        return this.projet;
    }

    public void setProjet(Projet projet){
        this.projet = projet;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjetRessource projetRessource = (ProjetRessource) o;
        return id != null && id.equals(projetRessource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

