package ma.sir.pmp.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "stagaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="stagaire_seq",sequenceName="stagaire_seq",allocationSize=1, initialValue = 1)


public class Stagaire extends AuditBusinessObject {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String tele;
    @Column(length = 500)
    private String fonction;


    public Stagaire(){
        super();
    }

    public Stagaire(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="employe_seq")
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
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTele(){
        return this.tele;
    }
    public void setTele(String tele){
        this.tele = tele;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
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
        Stagaire stagaire = (Stagaire) o;
        return id != null && id.equals(stagaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

