package cmpl.emr.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "taluka")
public class Locate implements Serializable {

    @Id
    @Column
    public String Taluka;
    
   public String getTaluka() {
        return Taluka;
    }

    public void setTaluka(String Taluka) {
        this.Taluka = Taluka;
    }
      
}
