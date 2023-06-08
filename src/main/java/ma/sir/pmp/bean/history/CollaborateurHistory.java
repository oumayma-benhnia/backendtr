package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "collaborateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="collaborateur_seq",sequenceName="collaborateur_seq",allocationSize=1, initialValue = 1)
public class CollaborateurHistory extends HistBusinessObject  {


    public CollaborateurHistory() {
    super();
    }

    public CollaborateurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="collaborateur_seq")
    public Long getId() {
    return id;
    }
}

