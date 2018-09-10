package cmpl.emr.model;
 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TIMETABLE")
public class UserTimeTable implements Serializable{
        
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_timetable_id;
        
        @Column(name = "dayCheck")
        private boolean dayCheck;
        
	@Column(name = "from_time1")
        private String from1;
	
        @Column(name = "to_time1")
        private String to1;
	
        @Column(name = "from_time2")
        private String from2;
        
        @Column(name = "to_time2")
        private String to2;

    public Integer getUser_timetable_id() {
        return user_timetable_id;
    }

    public void setUser_timetable_id(Integer user_timetable_id) {
        this.user_timetable_id = user_timetable_id;
    }
        
        
        
    public boolean isDayCheck() {
        return dayCheck;
    }

    public void setDayCheck(boolean dayCheck) {
        this.dayCheck = dayCheck;
    }

    public String getFrom1() {
        return from1;
    }

    public void setFrom1(String from1) {
        this.from1 = from1;
    }

    public String getTo1() {
        return to1;
    }

    public void setTo1(String to1) {
        this.to1 = to1;
    }

    public String getFrom2() {
        return from2;
    }

    public void setFrom2(String from2) {
        this.from2 = from2;
    }

    public String getTo2() {
        return to2;
    }

    public void setTo2(String to2) {
        this.to2 = to2;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user_timetable_id == null) ? 0 : user_timetable_id.hashCode());
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
        if (user_timetable_id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!user_timetable_id.equals(other.id)) {
            return false;
        }
       
        return true;
    }


    @Override
    public String toString() {
        return "Patient [id=" + user_timetable_id + ",dayCheck=" + dayCheck + ", from_time1=" + from1 + ","
                + "to_time1=" + to1 + ", from_time2=" + from2 + ",to_time2=" + to2 + "]";
    }
}
