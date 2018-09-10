package cmpl.emr.service;

import java.util.List;

import cmpl.emr.model.DepartmentType;


public interface DepartmentTypeService {

	DepartmentType findById(int id);
        
        void saveDepartmentType(DepartmentType departmentType);
        
	void deleteBySSO(int id);
	
	List<DepartmentType> findAll();
}
