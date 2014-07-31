package pol.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.UserEntity;
import pol.role.dao.RoleDao;
import pol.user.dao.UserDao;
import pol.user.service.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity> implements
		UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	protected AbstractDao<UserEntity> getDao() {
		return userDao;
	}

	public UserEntity getUserByLogin(String name) {

		return userDao.findByLogin(name);
	}

}
