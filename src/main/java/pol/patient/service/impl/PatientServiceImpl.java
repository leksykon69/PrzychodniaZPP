package pol.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.PatientEntity;
import pol.patient.dao.PatientDao;
import pol.patient.service.PatientService;

@Service
public class PatientServiceImpl extends AbstractServiceImpl<PatientEntity>
		implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	protected AbstractDao<PatientEntity> getDao() {
		return patientDao;
	}
}
