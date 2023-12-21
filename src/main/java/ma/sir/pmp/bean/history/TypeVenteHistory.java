package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;

import javax.persistence.*;


@Entity
@Table(name = "typeVente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="typeVente_seq",sequenceName="typeVente_seq",allocationSize=1, initialValue = 1)
public class TypeVenteHistory extends HistBusinessObject {


    public TypeVenteHistory () {
        super();}

    public TypeVenteHistory(Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="typeVente_seq")
    public Long getId() {
        return id;
    }
}
