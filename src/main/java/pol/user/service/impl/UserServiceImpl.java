package pol.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.RoleEntity;
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
	
public List<UserEntity> getUsersToDisplayList(RoleEntity role) {
		
		return role==null?findAll():findUsersByRole(role);
	}
	
	private List<UserEntity> findUsersByRole(RoleEntity role) {
		List<UserEntity> users = userDao.findAll();
		List<UserEntity> usersByRole= new ArrayList<UserEntity>();
		for(UserEntity user : users){
			if((role.getId()).equals(user.getRole().getId())){
				usersByRole.add(user);
			}
		}
		return usersByRole;
	}

}
