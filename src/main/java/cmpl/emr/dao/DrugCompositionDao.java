package cmpl.emr.dao;

import cmpl.emr.model.DrugComposition;
import java.util.List;

public interface DrugCompositionDao {
    List<DrugComposition> findAll();
	
    DrugComposition findById(int id);
}
