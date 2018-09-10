package cmpl.emr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cmpl.emr.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;



@Repository("tagDao")
public class TagDaoImpl extends AbstractDao<Integer, Tag> implements TagDao {
    
        @Autowired
	private SessionFactory sessionFactory;

	static final Logger logger = LoggerFactory.getLogger(TagDaoImpl.class);
	
	public Tag findById(int id) {
		Tag user = getByKey(id);
		
		return user;
	}

	public Tag findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", sso));
		Tag user = (Tag)crit.uniqueResult();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Tag> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("type"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Tag> users = (List<Tag>) criteria.list();

		return users;
	}

	public void save(Tag user) {
		persist(user);
	}
        
        public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", sso));
		Tag user = (Tag)crit.uniqueResult();
		delete(user);
	}

}
