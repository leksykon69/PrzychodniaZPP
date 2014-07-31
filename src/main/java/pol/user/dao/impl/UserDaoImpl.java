package pol.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.UserEntity;
import pol.user.dao.UserDao;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	@Transactional
	public UserEntity findByLogin(String name) {
		List<UserEntity> users = getEntityManager()
				.createNamedQuery(UserEntity.FIND_BY_LOGIN)
				.setParameter("login", name).getResultList();
		if (!users.isEmpty()) {
			return (UserEntity) users.get(0);
		}
		return null;
	}

}
