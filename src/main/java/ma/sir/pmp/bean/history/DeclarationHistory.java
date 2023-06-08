package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="declaration_seq",sequenceName="declaration_seq",allocationSize=1, initialValue = 1)
public class DeclarationHistory extends HistBusinessObject  {


    public DeclarationHistory() {
    super();
    }

    public DeclarationHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_seq")
    public Long getId() {
    return id;
    }
}

