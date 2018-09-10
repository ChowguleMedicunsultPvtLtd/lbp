package cmpl.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpl.emr.dao.UserDao;
import cmpl.emr.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
        private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setUsername(user.getUsername());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirst_name(user.getFirst_name());
			entity.setMiddle_name(user.getMiddle_name());
                        entity.setLast_name(user.getLast_name());
			entity.setGender(user.getGender());
                        entity.setBirthdate(user.getBirthdate());
                        entity.setBirthdate_estimated(user.isBirthdate_estimated());
                        entity.setHouseNo(user.getHouseNo());
                        entity.setArea(user.getArea());
                        entity.setGramPanchayat(user.getGramPanchayat());
                        entity.setVillage(user.getVillage());
                        entity.setTehsil(user.getTehsil());
                        entity.setDistrict(user.getDistrict());
                        entity.setState(user.getState());
                        entity.setPincode(user.getPincode());
                        entity.setMobile_no(user.getMobile_no());
                        entity.setAlternate_mobile(user.getAlternate_mobile());
                        entity.setEmail(user.getEmail());
                        entity.setAlternate_email(user.getAlternate_email());
                        entity.setQualification(user.getQualification());
                        entity.setUsername(user.getUsername());
                        entity.setPassword(user.getPassword());
                        entity.setUserProfiles(user.getUserProfiles());
                        entity.setDepartment(user.getDepartment());
                        entity.setUserTimeTable(user.getUserTimeTable());
                }
 	}
        
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
