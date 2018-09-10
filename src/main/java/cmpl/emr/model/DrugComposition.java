package cmpl.emr.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "DRUGCOMPOSITION")
public class DrugComposition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CompositionID;

    @Column(name = "CompositionDosage")
    private String CompositionDosage;

    @Column(name = "GenericName")
    private String GenericName;

    @Column(name = "Strength")
    private String Strength;

    @Column(name = "Unit")
    private String Unit;

    @Column(name = "CreatedBy")
    private String CreatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "CreatedOn", insertable = false, updatable = false)
    private Calendar CreatedOn;

    @Column(name = "UpdatedBy")
    private int UpdatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.INSERT)
    @Column(name = "UpdatedOn", insertable = false)
    private Calendar UpdatedOn;

    @Column(name = "IsDeleted")
    private int IsDeleted;

    public Integer getCompositionID() {
        return CompositionID;
    }

    public void setCompositionID(Integer CompositionID) {
        this.CompositionID = CompositionID;
    }

    public String getCompositionDosage() {
        return CompositionDosage;
    }

    public void setCompositionDosage(String CompositionDosage) {
        this.CompositionDosage = CompositionDosage;
    }

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String GenericName) {
        this.GenericName = GenericName;
    }

    public String getStrength() {
        return Strength;
    }

    public void setStrength(String Strength) {
        this.Strength = Strength;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Calendar getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Calendar CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    public Calendar getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(Calendar UpdatedOn) {
        this.UpdatedOn = UpdatedOn;
    }

    public int getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(int IsDeleted) {
        this.IsDeleted = IsDeleted;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CompositionID == null) ? 0 : CompositionID.hashCode());
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
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (CompositionID == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!CompositionID.equals(other.id)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Patient [id=" + CompositionID + ",CompositionDosage=" + CompositionDosage + ", GenericName=" + GenericName + ","
                + "Strength=" + Strength + ", Unit=" + Unit + ",CreatedBy=" + CreatedBy + ",CreatedOn=" + CreatedOn + ","
                +"UpdatedBy=" + UpdatedBy + ",UpdatedOn=" + UpdatedOn + ",IsDeleted=" + IsDeleted + "]";
    }
}
