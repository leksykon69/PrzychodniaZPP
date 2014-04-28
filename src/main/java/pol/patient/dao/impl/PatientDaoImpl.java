package pol.patient.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.PatientEntity;
import pol.patient.dao.PatientDao;

@Repository
public class PatientDaoImpl extends AbstractDaoImpl<PatientEntity> implements
		PatientDao {

	public PatientDaoImpl() {
		super(PatientEntity.class);
	}

	@Transactional
	public List<PatientEntity> findAllOrdered() {
		return getEntityManager().createNamedQuery(
				PatientEntity.FIND_ALL_ORDERED, PatientEntity.class)
				.getResultList();
	}

}
