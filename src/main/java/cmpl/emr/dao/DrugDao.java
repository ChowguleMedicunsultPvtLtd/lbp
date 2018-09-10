package cmpl.emr.dao;

import java.util.List;

import cmpl.emr.model.Drug;


public interface DrugDao {

	Drug findById(int id);
	
	Drug findBySSO(String sso);
	
	void save(Drug drug);
	
	void deleteBySSO(String sso);
	
	List<Drug> findAllDrugs();

}

