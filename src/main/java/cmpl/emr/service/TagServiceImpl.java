package cmpl.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpl.emr.dao.TagDao;
import cmpl.emr.model.Tag;


@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService{

	@Autowired
	private TagDao dao;

	public Tag findById(int id) {
		return dao.findById(id);
	}

	public Tag findBySSO(String sso) {
		Tag user = dao.findBySSO(sso);
		return user;
	}

	public void saveUser(Tag user) {
            if(null == user.getId()){
            	dao.save(user);
            }else{    
            Tag entity = dao.findById(user.getId());
            if(entity != null){
	        entity.setType(user.getType());
		entity.setAssignTag(user.getAssignTag());
            }    
            }
	}

	public void updateUser(Tag user) {
		Tag entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setType(user.getType());
			entity.setAssignTag(user.getAssignTag());
                       
                }
 	}
        
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<Tag> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		Tag user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
