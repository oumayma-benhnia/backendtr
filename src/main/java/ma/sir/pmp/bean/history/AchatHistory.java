package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="achat_seq",sequenceName="achat_seq",allocationSize=1, initialValue = 1)
public class AchatHistory extends HistBusinessObject  {


    public AchatHistory() {
        super();
    }

    public AchatHistory (Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="achat_seq")
    public Long getId() {
        return id;
    }
}

