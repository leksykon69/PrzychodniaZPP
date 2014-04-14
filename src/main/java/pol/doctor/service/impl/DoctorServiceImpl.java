package pol.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.doctor.dao.DoctorDao;
import pol.doctor.service.DoctorService;
import pol.entity.DoctorEntity;

@Service
public class DoctorServiceImpl extends AbstractServiceImpl<DoctorEntity>
		implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Override
	protected AbstractDao<DoctorEntity> getDao() {
		return doctorDao;
	}
}
