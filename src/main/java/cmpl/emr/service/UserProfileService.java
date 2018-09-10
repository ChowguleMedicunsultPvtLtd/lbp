package cmpl.emr.service;

import java.util.List;

import cmpl.emr.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);
        
	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
