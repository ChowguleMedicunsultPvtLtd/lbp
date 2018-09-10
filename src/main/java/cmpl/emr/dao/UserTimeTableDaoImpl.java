package cmpl.emr.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cmpl.emr.model.UserTimeTable;

@Repository("userTimeTableDao")
public class UserTimeTableDaoImpl  extends AbstractDao<Integer, UserTimeTable> implements UserTimeTableDao{

   @SuppressWarnings("unchecked")
    public List<UserTimeTable> findAll() {
        Criteria crit = createEntityCriteria();
	return (List<UserTimeTable>)crit.list();
    }

    @Override
    public UserTimeTable findById(int id) {
        return getByKey(id);
    }
    
}
