package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "fournisseur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="fournisseur_seq",sequenceName="fournisseur_seq",allocationSize=1, initialValue = 1)
public class FournisseurHistory extends HistBusinessObject  {


    public FournisseurHistory() {
    super();
    }

    public FournisseurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="fournisseur_seq")
    public Long getId() {
    return id;
    }
}

