package pol.visit.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.VisitEntity;
import pol.visit.dao.VisitDao;

@Repository
public class VisitDaoImpl extends AbstractDaoImpl<VisitEntity> implements
		VisitDao {

	public VisitDaoImpl() {
		super(VisitEntity.class);
	}

}
