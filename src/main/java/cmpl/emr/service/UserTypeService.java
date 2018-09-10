package cmpl.emr.service;

import java.util.List;

import cmpl.emr.model.UserType;

public interface UserTypeService {

	UserType findById(int id);
        
        void saveUserType(UserType userType);
        
	void deleteBySSO(int id);
	
	List<UserType> findAll();
        
        void updateUser(UserType userType);
	
}
