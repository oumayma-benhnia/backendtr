package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "ressource")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="ressource_seq",sequenceName="ressource_seq",allocationSize=1, initialValue = 1)
public class RessourceHistory extends HistBusinessObject  {


    public RessourceHistory() {
    super();
    }

    public RessourceHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ressource_seq")
    public Long getId() {
    return id;
    }
}

