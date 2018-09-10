/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpl.emr.service;

import cmpl.emr.model.Drug;
import java.util.List;

/**
 *
 * @author swdev10
 */
public interface DrugService {
    	Drug findById(int id);
	
	Drug findBySSO(String sso);
	
	void saveUser(Drug drug);
	
	void deleteUserBySSO(String sso);

	List<Drug> findAllDrugs(); 
	
	boolean isUserSSOUnique(Integer id, String sso);

}
