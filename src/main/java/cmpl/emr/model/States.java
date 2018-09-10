package cmpl.emr.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "states")
public class States implements Serializable {

    @Id
    @Column
    public String State;        
 
    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    
    
}
