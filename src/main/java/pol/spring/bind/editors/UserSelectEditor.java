package pol.spring.bind.editors;

import pol.abstractDao.AbstractDao;
import pol.entity.UserEntity;
import pol.user.dao.UserDao;

public class UserSelectEditor extends AbstractEntityEditor<UserEntity> {

	@Override
	public AbstractDao<?> getDao() {
		return context.getBean(UserDao.class);
	}

	@Override
	public Class<?> getClazz() {
		return UserEntity.class;
	}

}
