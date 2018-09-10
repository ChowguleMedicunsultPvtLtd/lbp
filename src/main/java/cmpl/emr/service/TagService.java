/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpl.emr.service;

import cmpl.emr.model.Tag;
import java.util.List;

/**
 *
 * @author swdev10
 */
public interface TagService {
    	Tag findById(int id);
	
	Tag findBySSO(String sso);
	
	void saveUser(Tag user);
	
	void updateUser(Tag user);
	
	void deleteUserBySSO(String sso);

	List<Tag> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);

}
