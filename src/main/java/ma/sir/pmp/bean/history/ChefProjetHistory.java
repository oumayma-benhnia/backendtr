package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "chef_projet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="chef_projet_seq",sequenceName="chef_projet_seq",allocationSize=1, initialValue = 1)
public class ChefProjetHistory extends HistBusinessObject  {


    public ChefProjetHistory() {
    super();
    }

    public ChefProjetHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="chef_projet_seq")
    public Long getId() {
    return id;
    }
}

