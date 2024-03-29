package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "categorie_materiel")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_materiel_seq",sequenceName="categorie_materiel_seq",allocationSize=1, initialValue = 1)
public class CategorieMaterielHistory extends HistBusinessObject  {


    public CategorieMaterielHistory() {
        super();}

    public CategorieMaterielHistory (Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_materiel_seq")
    public Long getId() {
        return id;
    }
}
