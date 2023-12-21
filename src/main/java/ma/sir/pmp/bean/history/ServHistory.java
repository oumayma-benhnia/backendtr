package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;

import javax.persistence.*;

@Entity
@Table(name = "serv_history")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="serv_history_seq", sequenceName="serv_history_seq", allocationSize=1, initialValue = 1)
public class ServHistory extends HistBusinessObject {

    public ServHistory() {
        super();
    }

    public ServHistory(Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="serv_history_seq")
    public Long getId() {
        return id;
    }
}