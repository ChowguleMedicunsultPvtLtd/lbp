package cmpl.emr.dao.patient;

import java.util.List;

import cmpl.emr.model.patient.Patient;


public interface PatientDao {

	Patient findById(int id);  
	
	Patient findByName(String first_name);   
	
	void save(Patient patient);
	
	void deleteById(int id);
	
	List<Patient> findAllPatients();

}

