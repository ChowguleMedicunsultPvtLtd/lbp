package cmpl.emr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cmpl.emr.model.DepartmentType;

@Repository("departmentTypeDao")
public class DepartmentTypeDaoImpl extends AbstractDao<Integer, DepartmentType> implements DepartmentTypeDao {
//	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public DepartmentType findById(int id) {
		DepartmentType user = getByKey(id);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<DepartmentType> findAllDepartments() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<DepartmentType> departments = (List<DepartmentType>) criteria.list();
		return departments;
	}

	public void save(DepartmentType department) {
		persist(department);
	}
        
        public void deleteBySSO(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		DepartmentType department = (DepartmentType)crit.uniqueResult();
		delete(department);
	}

}
