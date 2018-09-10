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

import cmpl.emr.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;



@Repository("DrugDao")
public class DrugDaoImpl extends AbstractDao<Integer, Drug> implements DrugDao {
    
        @Autowired
	private SessionFactory sessionFactory;

	static final Logger logger = LoggerFactory.getLogger(DrugDaoImpl.class);
	
	public Drug findById(int id) {
		Drug drug = getByKey(id);
		return drug;
	}

	public Drug findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("drugSSO", sso));
		Drug drug = (Drug)crit.uniqueResult();
		return drug;
	}

	@SuppressWarnings("unchecked")
	public List<Drug> findAllDrugs() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("drugSSO"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Drug> drugs = (List<Drug>) criteria.list();
		return drugs;
	}

	public void save(Drug drug) {
		persist(drug);
	}
        
        public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("drugSSO", sso));
		Drug drug = (Drug)crit.uniqueResult();
		delete(drug);
	}

}
