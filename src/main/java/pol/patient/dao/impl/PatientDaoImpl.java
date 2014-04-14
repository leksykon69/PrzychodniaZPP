package pol.patient.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.PatientEntity;
import pol.patient.dao.PatientDao;

@Repository
public class PatientDaoImpl extends AbstractDaoImpl<PatientEntity> implements
		PatientDao {

	public PatientDaoImpl() {
		super(PatientEntity.class);
	}

}
