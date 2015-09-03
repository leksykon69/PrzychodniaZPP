package pol.spring.bind.editors;

import pol.abstractDao.AbstractDao;
import pol.entity.RoleEntity;
import pol.role.dao.RoleDao;

public class RoleSelectEditor extends AbstractEntityEditor<RoleEntity> {

	@Override
	public AbstractDao<?> getDao() {
		return context.getBean(RoleDao.class);
	}

	@Override
	public Class<RoleEntity> getClazz() {
		return RoleEntity.class;
	}

}
