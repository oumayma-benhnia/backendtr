package ma.sir.pmp.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "ressource")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="ressource_seq",sequenceName="ressource_seq",allocationSize=1, initialValue = 1)
public class Ressource   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String nom;
    private BigDecimal prix = BigDecimal.ZERO;
    private BigDecimal cout = BigDecimal.ZERO;
    @Column(length = 500)
    private String type;
    @Column(length = 500)
    private String unite;

    private Fournisseur fournisseur ;
    
    private Materiel materiel ;
    
    private Collaborateur collaborateur ;
    
    private EntiteAdministrative entiteAdministrative ;
    


    public Ressource(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ressource_seq")
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
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }
    public BigDecimal getCout(){
        return this.cout;
    }
    public void setCout(BigDecimal cout){
        this.cout = cout;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getUnite(){
        return this.unite;
    }
    public void setUnite(String unite){
        this.unite = unite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Materiel getMateriel(){
        return this.materiel;
    }
    public void setMateriel(Materiel materiel){
        this.materiel = materiel;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Collaborateur getCollaborateur(){
        return this.collaborateur;
    }
    public void setCollaborateur(Collaborateur collaborateur){
        this.collaborateur = collaborateur;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EntiteAdministrative getEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ressource ressource = (Ressource) o;
        return id != null && id.equals(ressource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

