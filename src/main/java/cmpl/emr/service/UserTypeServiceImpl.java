package cmpl.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpl.emr.dao.UserTypeDao;
import cmpl.emr.model.UserType;


@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements UserTypeService{

	@Autowired
	private UserTypeDao dao;

	public UserType findById(int id) {
		return dao.findById(id);
	}

	public void saveUserType(UserType user) {
            if(null == user.getId()){
            	dao.save(user);
            }else{    
            UserType entity = dao.findById(user.getId());
            if(entity != null){
	        entity.setType(user.getType());
		entity.setSub_type(user.getSub_type());
            }    
            }
	}

	public void updateUser(UserType user) {
		UserType entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setType(user.getType());
			entity.setSub_type(user.getSub_type());
                        
                }
 	}
        
         public void deleteBySSO(int id) {
             dao.deleteBySSO(id);
        }
	
	public List<UserType> findAll() {
		return dao.findAllUsers();
	}

}
