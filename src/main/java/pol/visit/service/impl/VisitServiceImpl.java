package pol.visit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.VisitEntity;
import pol.visit.dao.VisitDao;
import pol.visit.service.VisitService;

@Service
public class VisitServiceImpl extends AbstractServiceImpl<VisitEntity>
		implements VisitService {

	@Autowired
	private VisitDao visitDao;

	@Override
	protected AbstractDao<VisitEntity> getDao() {
		return visitDao;
	}
}
