package pol.spring.bind.editors;

import pol.abstractDao.AbstractDao;
import pol.entity.PatientEntity;
import pol.patient.dao.PatientDao;

public class PatientSelectEditor extends AbstractEntityEditor<PatientEntity> {

	@Override
	public AbstractDao<?> getDao() {
		return context.getBean(PatientDao.class);
	}

	@Override
	public Class<?> getClazz() {
		return PatientDao.class;
	}

}
