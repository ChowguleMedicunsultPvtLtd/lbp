package cmpl.emr.service;

import cmpl.emr.dao.UserTimeTableDao;
import cmpl.emr.model.UserTimeTable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userTimeTableService")
@Transactional
public class UserTimeTableServiceImpl implements UserTimeTableService{

    @Autowired
	UserTimeTableDao dao;
    @Override
    public UserTimeTable findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<UserTimeTable> findAll() {
        return dao.findAll();
    }
    
    
}
