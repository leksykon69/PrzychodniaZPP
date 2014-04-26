package pol.spring.bind.editors;

import pol.abstractDao.AbstractDao;
import pol.doctor.dao.DoctorDao;
import pol.entity.DoctorEntity;

public class DoctorSelectEditor extends AbstractEntityEditor<DoctorEntity> {

	@Override
	public AbstractDao<?> getDao() {
		return context.getBean(DoctorDao.class);
	}

	@Override
	public Class<DoctorEntity> getClazz() {
		return DoctorEntity.class;
	}

}
