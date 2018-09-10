package cmpl.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpl.emr.dao.DrugDao;
import cmpl.emr.model.Drug;
import java.util.Objects;


@Service("drugService")
@Transactional
public class DrugServiceImpl implements DrugService{

	@Autowired
	private DrugDao dao;

	public Drug findById(int id) {
		return dao.findById(id);
	}

	public Drug findBySSO(String sso) {
		Drug drug = dao.findBySSO(sso);
		return drug;
	}

	public void saveUser(Drug drug) {
            if(null == drug.getDrugID()){
            	dao.save(drug);
            }else{    
            Drug entity = dao.findById(drug.getDrugID());
            if(entity != null){
	        entity.setDiagnosisName(drug.getDiagnosisName());
		entity.setDosageForm(drug.getDosageForm());
                entity.setBrandName(drug.getBrandName());
                entity.setCompany(drug.getCompany());
                entity.setDivision(drug.getDivision());
                entity.setDose(drug.getDose());
                entity.setFrequency(drug.getFrequency());
                entity.setDuration(drug.getDuration());
                entity.setRoute(drug.getRoute());
                entity.setRemark(drug.getRemark());
                entity.setCreator(drug.getCreator());
                entity.setUpdatedBy(drug.getUpdatedBy());
                entity.setUpdatedOn(drug.getUpdatedOn());
                entity.setIsDeleted(drug.getIsDeleted());
            }    
            }
	}

	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<Drug> findAllDrugs() {
		return dao.findAllDrugs();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		Drug drug = findBySSO(sso);
		return ( drug == null || ((id != null) && (drug.getDrugID() == id)));
	}
	
}
