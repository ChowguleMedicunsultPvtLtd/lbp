package cmpl.emr.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cmpl.emr.model.DrugComposition;

@Repository("drugCompositionDao")
public class DrugCompositionDaoImpl  extends AbstractDao<Integer, DrugComposition> implements DrugCompositionDao{

   @SuppressWarnings("unchecked")
    public List<DrugComposition> findAll() {
        Criteria crit = createEntityCriteria();
	return (List<DrugComposition>)crit.list();
    }

    @Override
    public DrugComposition findById(int id) {
        return getByKey(id);
    }
    
}
