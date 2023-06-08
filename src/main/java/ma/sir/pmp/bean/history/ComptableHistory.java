package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="comptable_seq",sequenceName="comptable_seq",allocationSize=1, initialValue = 1)
public class ComptableHistory extends HistBusinessObject  {


    public ComptableHistory() {
    super();
    }

    public ComptableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="comptable_seq")
    public Long getId() {
    return id;
    }
}

