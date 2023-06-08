package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_seq",sequenceName="paiement_seq",allocationSize=1, initialValue = 1)
public class PaiementHistory extends HistBusinessObject  {


    public PaiementHistory() {
    super();
    }

    public PaiementHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_seq")
    public Long getId() {
    return id;
    }
}

