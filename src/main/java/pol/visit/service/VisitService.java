package pol.visit.service;

import java.util.List;
import java.util.Map;

import pol.abstractService.AbstractService;
import pol.entity.VisitEntity;
import pol.visitsController.AbstractSelectionVisitForm;
import pol.visitsController.VisitsGeneratorForm;

public interface VisitService extends AbstractService<VisitEntity> {

	public List<VisitEntity> generateAndSaveVisits(VisitsGeneratorForm form);

	public Map<String, List<VisitEntity>> getVisitToDisplayList(
			AbstractSelectionVisitForm form);

	public List<VisitEntity> getVisitsByForm(AbstractSelectionVisitForm form);

}
