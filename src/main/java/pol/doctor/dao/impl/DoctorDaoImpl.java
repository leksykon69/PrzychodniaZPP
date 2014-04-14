package pol.doctor.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.doctor.dao.DoctorDao;
import pol.entity.DoctorEntity;

@Repository
public class DoctorDaoImpl extends AbstractDaoImpl<DoctorEntity> implements
		DoctorDao {

	public DoctorDaoImpl() {
		super(DoctorEntity.class);
	}

}
