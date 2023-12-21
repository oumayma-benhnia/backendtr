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


@Entity
@Table(name = "service")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="service_seq",sequenceName="service_seq",allocationSize=1, initialValue = 1)
public class ServiceHistory extends HistBusinessObject {


    public ServiceHistory() {
        super();}

    public ServiceHistory(Long id) {
        super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="service_seq")
    public Long getId() {
        return id;
    }
}



