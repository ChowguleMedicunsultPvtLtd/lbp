package cmpl.emr.dao.patient;

import cmpl.emr.dao.AbstractDao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cmpl.emr.model.patient.Patient;



@Repository("patientDao")
public class PatientDaoImpl extends AbstractDao<Integer, Patient> implements PatientDao {

	static final Logger logger = LoggerFactory.getLogger(PatientDaoImpl.class);
	
	public Patient findById(int id) {
		Patient patient = getByKey(id);
//		if(patient!=null){
		//	Hibernate.initialize(patient.getUserProfiles());
//		}
		return patient;
	}

	public Patient findByName(String first_name) {
		logger.info("PatientName : {}", first_name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("first_name", first_name));
		Patient patient = (Patient)crit.uniqueResult();
//		if(patient!=null){
		//	Hibernate.initialize(patient.getUserProfiles());
//		}
		return patient;
	}

	@SuppressWarnings("unchecked")
	public List<Patient> findAllPatients() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("first_name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Patient> patient = (List<Patient>) criteria.list();
		return patient;
	}

	public void save(Patient patient) {
		persist(patient);
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Patient patient = (Patient)crit.uniqueResult();
		delete(patient);
	}

}
