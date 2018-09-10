package cmpl.emr.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Integer id;
    
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

    @Column(name = "alternate_mobile")
    private String alternate_mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "alternate_email")
    private String alternate_email;
    
    @Column(name = "qualification")
    private String qualification;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConf;
    
    @Column(name = "department")
    private String department;

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
    
    @NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "USER_USER_TIMETABLE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_TIMETABLE_ID") })
    private List<UserTimeTable> userTimeTable;
    
   

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

    public String getAlternate_mobile() {
        return alternate_mobile;
    }

    public void setAlternate_mobile(String alternate_mobile) {
        this.alternate_mobile = alternate_mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternate_email() {
        return alternate_email;
    }

    public void setAlternate_email(String alternate_email) {
        this.alternate_email = alternate_email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConf() {
        return passwordConf;
    }

    public void setPasswordConf(String passwordConf) {
        this.passwordConf = passwordConf;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
        this.date_changed = date_changed;
    }

    public Set<UserProfile> getUserProfiles() {
		return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
    }
    
     public List<UserTimeTable> getUserTimeTable() {
        return userTimeTable;
    }

    public void setUserTimeTable(List<UserTimeTable> userTimeTable) {
        this.userTimeTable = userTimeTable;
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
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
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
                + "alternate_mobile=" + alternate_mobile + ", email=" + email + ",alternate_email=" + alternate_email + ", qualification=" + qualification + ","
                + "username=" + username + ",department=" + department + ","
                +"creator=" + creator + ",date_created=" + date_created + ", changed_by=" + changed_by + ",date_changed=" + date_changed + "]";
    }
}    
