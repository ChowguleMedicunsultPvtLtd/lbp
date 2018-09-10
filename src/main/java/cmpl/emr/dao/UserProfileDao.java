package cmpl.emr.dao;

import java.util.List;

import cmpl.emr.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
