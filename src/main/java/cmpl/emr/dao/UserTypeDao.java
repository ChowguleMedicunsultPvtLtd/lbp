package cmpl.emr.dao;

import java.util.List;

import cmpl.emr.model.UserType;


public interface UserTypeDao {

	UserType findById(int id);
	
	void save(UserType user);
	
	void deleteBySSO(int id);
	
	List<UserType> findAllUsers();

}

