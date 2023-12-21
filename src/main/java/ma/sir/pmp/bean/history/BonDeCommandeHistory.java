package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "bonDeCommande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bonDeCommande_seq",sequenceName="bonDeCommande_seq",allocationSize=1, initialValue = 1)
public class BonDeCommandeHistory extends HistBusinessObject  {


    public BonDeCommandeHistory() {
        super();
    }

    public BonDeCommandeHistory (Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bonDeCommande_seq")
    public Long getId() {
        return id;
    }
}

