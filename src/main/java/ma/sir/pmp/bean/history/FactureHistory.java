package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "facture")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="facture_seq",sequenceName="facture_seq",allocationSize=1, initialValue = 1)
public class FactureHistory extends HistBusinessObject  {


    public FactureHistory() {
    super();
    }

    public FactureHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="facture_seq")
    public Long getId() {
    return id;
    }
}

