package pol.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;

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
		List<UserEntity> users = findByNamedQueryAndParams(UserEntity.FIND_BY_LOGIN, ImmutableMap.of("login", name));
		return users.stream().findAny().orElse(null);
	}

}
