package cmpl.emr.service.patient;

import java.util.List;

import cmpl.emr.model.patient.Patient;


public interface PatientService {
	
	Patient findById(int id);
	
	Patient findByName(String first_name);   
	
	void savePatient(Patient patient);
	
/*	void updatePatient(Patient patient);   */
	
	void deletePatientById(int id);

	List<Patient> findAllPatients(); 

}