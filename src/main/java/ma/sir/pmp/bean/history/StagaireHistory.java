package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonInclude;
        import ma.sir.pmp.zynerator.history.HistBusinessObject;

        import javax.persistence.*;




        import com.fasterxml.jackson.annotation.JsonInclude;
        import ma.sir.pmp.zynerator.history.HistBusinessObject;

        import javax.persistence.*;


        import com.fasterxml.jackson.annotation.JsonInclude;
        import ma.sir.pmp.zynerator.history.HistBusinessObject;

        import javax.persistence.*;




        import com.fasterxml.jackson.annotation.JsonInclude;
        import ma.sir.pmp.zynerator.history.HistBusinessObject;
        import javax.persistence.*;


@Entity
@Table(name = "stagaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="stagaire_seq",sequenceName="stagaire_seq",allocationSize=1, initialValue = 1)
public class StagaireHistory  extends HistBusinessObject {


    public StagaireHistory () {
        super();}

    public StagaireHistory (Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="stagaire_seq")
    public Long getId() {
        return id;
    }
}
