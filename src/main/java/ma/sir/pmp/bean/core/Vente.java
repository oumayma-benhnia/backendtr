package ma.sir.pmp.bean.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "type_projet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_projet_seq",sequenceName="type_projet_seq",allocationSize=1, initialValue = 1)
public class Vente extends AuditBusinessObject {
    private Long id;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private TypeVente typeVente ;
    private LocalDateTime dateVente ;
    private Client client;
    public Vente(){
        super();
    }

    public Vente(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vente_seq")
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeVente getTypeVente() {
        return typeVente;
    }

    public void setTypeVente(TypeVente typeVente) {
        this.typeVente = typeVente;
    }

    public LocalDateTime getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        Vente vente = (Vente) o;
        return id != null && id.equals(vente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
