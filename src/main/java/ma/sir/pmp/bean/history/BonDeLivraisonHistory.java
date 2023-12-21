package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "bonDeLivraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bonDeLivraison_seq",sequenceName="bonDeLivraison_seq",allocationSize=1, initialValue = 1)
public class BonDeLivraisonHistory extends HistBusinessObject  {


    public BonDeLivraisonHistory() {
        super();
    }

    public BonDeLivraisonHistory (Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bonDeLivraison_seq")
    public Long getId() {
        return id;
    }
}
