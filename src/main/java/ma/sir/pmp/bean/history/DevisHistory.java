package ma.sir.pmp.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;

import javax.persistence.*;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import javax.persistence.*;


    @Entity
    @Table(name = "devis")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @SequenceGenerator(name="devis_seq",sequenceName="devis_seq",allocationSize=1, initialValue = 1)
    public class DevisHistory  extends HistBusinessObject {


        public DevisHistory() {
            super();}

        public DevisHistory (Long id) {
            super(id);
        }

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="devis_seq")
        public Long getId() {
            return id;
        }
    }

