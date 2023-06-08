package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "entite_administrative")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="entite_administrative_seq",sequenceName="entite_administrative_seq",allocationSize=1, initialValue = 1)
public class EntiteAdministrativeHistory extends HistBusinessObject  {


    public EntiteAdministrativeHistory() {
    super();
    }

    public EntiteAdministrativeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="entite_administrative_seq")
    public Long getId() {
    return id;
    }
}

