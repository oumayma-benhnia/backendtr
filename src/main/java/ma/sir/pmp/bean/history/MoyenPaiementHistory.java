package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "moyen_paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="moyen_paiement_seq",sequenceName="moyen_paiement_seq",allocationSize=1, initialValue = 1)
public class MoyenPaiementHistory extends HistBusinessObject  {


    public MoyenPaiementHistory() {
    super();
    }

    public MoyenPaiementHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="moyen_paiement_seq")
    public Long getId() {
    return id;
    }
}

