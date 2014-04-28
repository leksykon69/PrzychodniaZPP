package pol.patient.dao;

import java.util.List;

import pol.abstractDao.AbstractDao;
import pol.entity.PatientEntity;

public interface PatientDao extends AbstractDao<PatientEntity> {

	public List<PatientEntity> findAllOrdered();

}
