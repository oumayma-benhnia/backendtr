package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "type_declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_declaration_seq",sequenceName="type_declaration_seq",allocationSize=1, initialValue = 1)
public class TypeDeclarationHistory extends HistBusinessObject  {


    public TypeDeclarationHistory() {
    super();
    }

    public TypeDeclarationHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_declaration_seq")
    public Long getId() {
    return id;
    }
}

