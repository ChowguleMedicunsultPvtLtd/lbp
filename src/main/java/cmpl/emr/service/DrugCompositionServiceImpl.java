package cmpl.emr.service;

import cmpl.emr.dao.DrugCompositionDao;
import cmpl.emr.model.DrugComposition;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("drugCompositionService")
@Transactional
public class DrugCompositionServiceImpl implements DrugCompositionService{

    @Autowired
	DrugCompositionDao dao;
    @Override
    public DrugComposition findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<DrugComposition> findAll() {
        return dao.findAll();
    }
    
    
}
