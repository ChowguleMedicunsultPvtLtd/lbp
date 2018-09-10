package cmpl.emr.model.patient;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Patient")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotEmpty
    @Column(name = "first_name", nullable=false)
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;
 
    @Column(name = "last_name")
    private String last_name;

    @NotEmpty    
    @Column(name = "gender", nullable=false)
    private String gender;

    @NotNull
    @Column(name = "birthdate", nullable=false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;

    @Column(name = "birthdate_estimated")
    private boolean birthdate_estimated;
 
    @Column(name = "HouseNo")
    private String HouseNo;

    @Column(name = "Area")
    private String Area;

    @Column(name = "GramPanchayat")
    private String GramPanchayat;

    @Column(name = "Village")
    private String Village;

    @Column(name = "Tehsil")
    private String Tehsil;

    @Column(name = "District")
    private String District;

    @Column(name = "State")
    private String State;

    @Column(name = "Pincode")
    private String Pincode;

    @Column(name = "mobile_no")
    private String mobile_no;

    @Column(name = "landline_no")
    private String landline_no;

    @Column(name = "Email")
    private String email;

    @Column(name = "rel_type")
    private String rel_type;

    @Column(name = "rel_name")
    private String rel_name;

    @Column(name = "isAlive")
    private String isAlive;

    @Column(name = "died_on")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date died_on;

    @Column(name = "death_cause")
    private String death_cause;

    @Column(name = "educational_data")
    private String educational_data;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "mother_name")
    private String mother_name;

    @Column(name = "religion")
    private String religion;

    @Column(name = "caste")
    private String caste;

    @Column(name = "tags")
    private String tags;

    @Column(name = "refered_by")
    private String refered_by;

    @Column(name = "Aadhar_no")
    private String Aadhar_no;

    @Column(name = "creator")
    private int creator;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS) 
    @Column(name="date_created", insertable=false,updatable=false)
    private Calendar date_created;

    @Column(name = "changed_by")
    private int changed_by;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.INSERT) 
    @Column(name="date_changed", insertable=false)
    private Calendar date_changed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
        System.out.println("first_name:"+first_name);
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

     public boolean isBirthdate_estimated() {
        return birthdate_estimated;
    }

    public void setBirthdate_estimated(boolean birthdate_estimated) {
        this.birthdate_estimated = birthdate_estimated;
    }
    
    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String HouseNo) {
        this.HouseNo = HouseNo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getGramPanchayat() {
        return GramPanchayat;
    }

    public void setGramPanchayat(String GramPanchayat) {
        this.GramPanchayat = GramPanchayat;
    }

    public String getVillage() {
        return Village;
    }

    public void setVillage(String Village) {
        this.Village = Village;
    }

    public String getTehsil() {
        return Tehsil;
    }

    public void setTehsil(String Tehsil) {
        this.Tehsil = Tehsil;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getLandline_no() {
        return landline_no;
    }

    public void setLandline_no(String landline_no) {
        this.landline_no = landline_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRel_type() {
        return rel_type;
    }

    public void setRel_type(String rel_type) {
        this.rel_type = rel_type;
    }

    public String getRel_name() {
        return rel_name;
    }

    public void setRel_name(String rel_name) {
        this.rel_name = rel_name;
    }

    public String getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(String isAlive) {
        this.isAlive = isAlive;
    }

    public Date getDied_on() {
        return died_on;
    }

    public void setDied_on(Date died_on) {
        this.died_on = died_on;
    }

    public String getDeath_cause() {
        return death_cause;
    }

    public void setDeath_cause(String death_cause) {
        this.death_cause = death_cause;
    }

    public String getEducational_data() {
        return educational_data;
    }

    public void setEducational_data(String educational_data) {
        this.educational_data = educational_data;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getRefered_by() {
        return refered_by;
    }

    public void setRefered_by(String refered_by) {
        this.refered_by = refered_by;
    }

    public String getAadhar_no() {
        return Aadhar_no;
    }

    public void setAadhar_no(String Aadhar_no) {
        this.Aadhar_no = Aadhar_no;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Calendar getDate_created() {
        return date_created;
    }

    public void setDate_created(Calendar date_created) {
        this.date_created = date_created;
    }

    public int getChanged_by() {
        return changed_by;
    }

    public void setChanged_by(int changed_by) {
        this.changed_by = changed_by;
    }

    public Calendar getDate_changed() {
        return date_changed;
    }

    public void setDate_changed(Calendar date_changed) {
        this.date_changed = this.date_changed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (!(obj instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) obj;
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
        return "Patient [id=" + id + ", first_name=" + first_name + ",middle_name=" + middle_name + ", last_name=" + last_name + ","
                + "gender=" + gender + ", birthdate=" + birthdate + ",birthdate_estimated=" + birthdate_estimated + ", HouseNo=" + HouseNo + ","
                + "Area=" + Area + ", GramPanchayat=" + GramPanchayat + ",Village=" + Village + ", Tehsil=" + Tehsil + ","
                + "District=" + District + ", State=" + State + ",Pincode=" + Pincode + ", mobile_no=" + mobile_no + ","
                + "landline_no=" + landline_no + ", Email=" + email + ",rel_type=" + rel_type + ", rel_name=" + rel_name + ","
                + "isAlive=" + isAlive + ", died_on=" + died_on + ",death_cause=" + death_cause + ", educational_data=" + educational_data + ","
                + "occupation=" + occupation + ", mother_name=" + mother_name + ",religion=" + religion + ", caste=" + caste + ","
                + "tags=" + tags + ", refered_by=" + refered_by + ",Aadhar_no=" + Aadhar_no + ", creator=" + creator + ","
                + "date_created=" + date_created + ", changed_by=" + changed_by + ",date_changed=" + date_changed + "]";
    }
}    
