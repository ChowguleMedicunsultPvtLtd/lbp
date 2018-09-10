package cmpl.emr.service.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpl.emr.dao.patient.PatientDao;
import cmpl.emr.model.patient.Patient;
import cmpl.emr.service.patient.PatientService;


@Service("PatientService")
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao dao;

	public Patient findById(int id) {
		return dao.findById(id);
	}

	public Patient findByName(String first_name) {
		Patient patient = dao.findByName(first_name);
		return patient;
	}

	public void savePatient(Patient patient) {
		dao.save(patient);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
/*	public void updatePatient(Patient patient) {
		Patient entity = dao.findById(patient.getId());
		if(entity!=null){
			entity.setSsoId(patient.getSsoId());
			if(!patient.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(patient.getPassword()));
			}
			entity.setFirstName(patient.getFirstName());
			entity.setLastName(patient.getLastName());
			entity.setEmail(patient.getEmail());
			entity.setUserProfiles(patient.getUserProfiles());
		}
	}

	*/
	public void deletePatientById(int id) {
		dao.deleteById(id);
	}

	public List<Patient> findAllPatients() {
		return dao.findAllPatients();
	}
	
}

