package pol.user.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.UserEntity;
import pol.user.dao.UserDao;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

}
