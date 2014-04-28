package pol.doctor.dao;

import java.util.List;

import pol.abstractDao.AbstractDao;
import pol.entity.DoctorEntity;

public interface DoctorDao extends AbstractDao<DoctorEntity> {

	public List<DoctorEntity> findAllOrdered();
}
