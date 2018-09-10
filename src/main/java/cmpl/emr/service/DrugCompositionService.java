package cmpl.emr.service;

import cmpl.emr.model.DrugComposition;
import java.util.List;

public interface DrugCompositionService {
        DrugComposition findById(int id);

	List<DrugComposition> findAll();
}
