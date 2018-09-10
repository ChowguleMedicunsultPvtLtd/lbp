package cmpl.emr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "districts")
public class Districts implements Serializable {

    @Id
    @Column
    public String District ;
    
    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

}
