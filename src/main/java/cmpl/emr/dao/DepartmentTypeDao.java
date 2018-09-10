package cmpl.emr.dao;

import java.util.List;

import cmpl.emr.model.DepartmentType;


public interface DepartmentTypeDao {

	DepartmentType findById(int id);
	
	void save(DepartmentType department);
	
	void deleteBySSO(int id);
	
	List<DepartmentType> findAllDepartments();

}

