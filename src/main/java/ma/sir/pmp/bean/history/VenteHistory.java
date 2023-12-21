package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;

import javax.persistence.*;


@Entity
@Table(name = "vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_seq",sequenceName="vente_seq",allocationSize=1, initialValue = 1)
public class VenteHistory extends HistBusinessObject {


    public VenteHistory () {
        super();}

    public VenteHistory(Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vente_seq")
    public Long getId() {
        return id;
    }
}
