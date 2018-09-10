package cmpl.emr.dao;

import java.util.List;

import cmpl.emr.model.Tag;


public interface TagDao {

	Tag findById(int id);
	
	Tag findBySSO(String sso);
	
	void save(Tag user);
	
       
        
	void deleteBySSO(String sso);
	
	List<Tag> findAllUsers();

}

