package cmpl.emr.dao;

import cmpl.emr.model.UserTimeTable;
import java.util.List;

public interface UserTimeTableDao {
    List<UserTimeTable> findAll();
	
    UserTimeTable findById(int id);
}
