package pol.user.dao;

import pol.abstractDao.AbstractDao;
import pol.entity.UserEntity;

public interface UserDao extends AbstractDao<UserEntity> {

	UserEntity findByLogin(String name);

}
