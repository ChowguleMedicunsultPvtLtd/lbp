package cmpl.emr.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "drug")
public class Drug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer drugID;

    @NotEmpty
    @Column(name = "diagnosisName", nullable = false)
    private String DiagnosisName;

    @Column(name = "dosageForm")
    private String DosageForm;

    @Column(name = "brandName")
    private String BrandName;

    @NotEmpty
    @Column(name = "company", nullable = false)
    private String Company;

    @Column(name = "division")
    private String Division;

    @Column(name = "Dose")
    private String Dose;

    @Column(name = "Frequency")
    private String Frequency;

    @Column(name = "Duration")
    private String Duration;

    @Column(name = "Route")
    private String Route;

    @Column(name = "Remark")
    private String Remark;

    @Column(name = "CreatedBy")
    private int creator;

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

     @Column(name = "drugSSO")
    private String drugSSO;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "DRUG_DRUGCOMPOSITION",
            joinColumns = {
                @JoinColumn(name = "drug_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "drug_composition_id")})
    private List<DrugComposition> drugComposition;

    public Integer getDrugID() {
        return drugID;
    }

    public void setDrugID(Integer drugID) {
        this.drugID = drugID;
    }

    public String getDiagnosisName() {
        return DiagnosisName;
    }

    public void setDiagnosisName(String DiagnosisName) {
        this.DiagnosisName = DiagnosisName;
    }

    public String getDosageForm() {
        return DosageForm;
    }

    public void setDosageForm(String DosageForm) {
        this.DosageForm = DosageForm;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String Division) {
        this.Division = Division;
    }

    
    
    public String getDose() {
        return Dose;
    }

    public void setDose(String Dose) {
        this.Dose = Dose;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String Route) {
        this.Route = Route;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
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

    public String getDrugSSO() {
        return drugSSO;
    }

    public void setDrugSSO(String drugSSO) {
        this.drugSSO = drugSSO;
    }

    public List<DrugComposition> getDrugComposition() {
        return drugComposition;
    }

    public void setDrugComposition(List<DrugComposition> drugComposition) {
        this.drugComposition = drugComposition;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((drugID == null) ? 0 : drugID.hashCode());
//        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
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
        if (drugID == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!drugID.equals(other.id)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Drug [drugID=" + drugID + ", DiagnosisName=" + DiagnosisName + ",BrandName=" + BrandName + ", DosageForm=" + DosageForm + ","
                + "Company=" + Company + ", Division=" + Division + ",Dose=" + Dose + ", Frequency=" + Frequency + ","
                + "Duration=" + Duration + ", Route=" + Route + ",Remark=" + Remark + ",drugSSO=" + drugSSO + ","
                + "creator=" + creator + ",CreatedOn=" + CreatedOn + ", UpdatedBy=" + UpdatedBy + ",UpdatedOn=" + UpdatedOn + ",IsDeleted=" + IsDeleted + "]";
    }
}
