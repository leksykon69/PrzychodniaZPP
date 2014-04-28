package pol.doctor.dao.impl;

import java.util.List;

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

	public List<DoctorEntity> findAllOrdered() {
		return getEntityManager().createNamedQuery(
				DoctorEntity.FIND_ALL_ORDERED, DoctorEntity.class)
				.getResultList();
	}

}
