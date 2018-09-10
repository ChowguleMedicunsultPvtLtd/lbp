package cmpl.emr.service;

import cmpl.emr.model.UserTimeTable;
import java.util.List;

public interface UserTimeTableService {
        UserTimeTable findById(int id);

	List<UserTimeTable> findAll();
}
