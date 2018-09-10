package cmpl.emr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "department")
public class DepartmentType implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotEmpty
    @Column(name = "type", nullable=false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result= prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DepartmentType)) {
            return false;
        }
        DepartmentType other = (DepartmentType) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
       
        return true;
    }

    /*
	 * DO-NOT-INCLUDE passwords in toString function.
	 * It is done here just for convenience purpose.
     */
    @Override
    public String toString() {
        return "DepartmentType [id=" + id + ", type=" + type + "]";
    }
    
}
