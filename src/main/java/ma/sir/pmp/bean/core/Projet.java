package ma.sir.pmp.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "projet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="projet_seq",sequenceName="projet_seq",allocationSize=1, initialValue = 1)
public class Projet   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private BigDecimal budget = BigDecimal.ZERO;
    @Column(length = 500)
    private String progression;
    private LocalDateTime dateDebut ;
    private LocalDateTime dateFinEstime ;
    private LocalDateTime dateFin ;

    private TypeProjet typeProjet ;
    
    private Client client ;
    
    private ChefProjet chefProjet ;
    

    private List<ProjetRessource> projetRessources ;
    private List<Tache> taches ;
    private List<Remarque> remarques ;

    public Projet(){
        super();
    }

    public Projet(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="projet_seq")
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeProjet getTypeProjet(){
        return this.typeProjet;
    }
    public void setTypeProjet(TypeProjet typeProjet){
        this.typeProjet = typeProjet;
    }
    public BigDecimal getBudget(){
        return this.budget;
    }
    public void setBudget(BigDecimal budget){
        this.budget = budget;
    }
    public String getProgression(){
        return this.progression;
    }
    public void setProgression(String progression){
        this.progression = progression;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFinEstime(){
        return this.dateFinEstime;
    }
    public void setDateFinEstime(LocalDateTime dateFinEstime){
        this.dateFinEstime = dateFinEstime;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    @OneToMany(mappedBy = "projet")
    public List<ProjetRessource> getProjetRessources(){
        return this.projetRessources;
    }
    public void setProjetRessources(List<ProjetRessource> projetRessources){
        this.projetRessources = projetRessources;
    }
    @OneToMany
    public List<Tache> getTaches(){
        return this.taches;
    }
    public void setTaches(List<Tache> taches){
        this.taches = taches;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ChefProjet getChefProjet(){
        return this.chefProjet;
    }
    public void setChefProjet(ChefProjet chefProjet){
        this.chefProjet = chefProjet;
    }
    @OneToMany(mappedBy = "projet")
    public List<Remarque> getRemarques(){
        return this.remarques;
    }
    public void setRemarques(List<Remarque> remarques){
        this.remarques = remarques;
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
        Projet projet = (Projet) o;
        return id != null && id.equals(projet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

