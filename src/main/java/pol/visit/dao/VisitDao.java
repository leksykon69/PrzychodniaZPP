package pol.visit.dao;

import java.util.List;

import pol.abstractDao.AbstractDao;
import pol.entity.VisitEntity;
import pol.visitsController.AbstractSelectionVisitForm;

public interface VisitDao extends AbstractDao<VisitEntity> {

	List<VisitEntity> getVisitsListByForm(AbstractSelectionVisitForm form);

}
