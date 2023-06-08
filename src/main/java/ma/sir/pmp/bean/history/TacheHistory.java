package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "tache")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="tache_seq",sequenceName="tache_seq",allocationSize=1, initialValue = 1)
public class TacheHistory extends HistBusinessObject  {


    public TacheHistory() {
    super();
    }

    public TacheHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tache_seq")
    public Long getId() {
    return id;
    }
}

