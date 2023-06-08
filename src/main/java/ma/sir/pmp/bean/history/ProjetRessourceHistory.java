package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "projet_ressource")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="projet_ressource_seq",sequenceName="projet_ressource_seq",allocationSize=1, initialValue = 1)
public class ProjetRessourceHistory extends HistBusinessObject  {


    public ProjetRessourceHistory() {
    super();
    }

    public ProjetRessourceHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="projet_ressource_seq")
    public Long getId() {
    return id;
    }
}

