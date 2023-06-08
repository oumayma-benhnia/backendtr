package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "type_projet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_projet_seq",sequenceName="type_projet_seq",allocationSize=1, initialValue = 1)
public class TypeProjetHistory extends HistBusinessObject  {


    public TypeProjetHistory() {
    super();
    }

    public TypeProjetHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_projet_seq")
    public Long getId() {
    return id;
    }
}

