package cmpl.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpl.emr.dao.DepartmentTypeDao;
import cmpl.emr.model.DepartmentType;


@Service("departmentTypeService")
@Transactional
public class DepartmentTypeServiceImpl implements DepartmentTypeService{

	@Autowired
	private DepartmentTypeDao dao;

	public DepartmentType findById(int id) {
		return dao.findById(id);
	}

	public void saveDepartmentType(DepartmentType department) {
            if(null == department.getId()){
            	dao.save(department);
            }else{    
            DepartmentType entity = dao.findById(department.getId());
            if(entity != null){
	        entity.setType(department.getType());
            }    
            }
	}

        public void deleteBySSO(int id) {
             dao.deleteBySSO(id);
        }
	
	public List<DepartmentType> findAll() {
		return dao.findAllDepartments();
	}

}
