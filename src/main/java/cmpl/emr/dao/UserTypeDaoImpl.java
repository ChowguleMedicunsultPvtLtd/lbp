package cmpl.emr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cmpl.emr.model.UserType;

@Repository("userTypeDao")
public class UserTypeDaoImpl extends AbstractDao<Integer, UserType> implements UserTypeDao {
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public UserType findById(int id) {
		UserType user = getByKey(id);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<UserType> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserType> users = (List<UserType>) criteria.list();
		return users;
	}

	public void save(UserType user) {
		persist(user);
	}
        
        public void deleteBySSO(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		UserType user = (UserType)crit.uniqueResult();
		delete(user);
	}

}
