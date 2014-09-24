package pol.user.service;

import java.util.List;

import pol.abstractService.AbstractService;
import pol.entity.RoleEntity;
import pol.entity.UserEntity;

public interface UserService extends AbstractService<UserEntity> {

	UserEntity getUserByLogin(String name);
	
	List<UserEntity> getUsersToDisplayList(RoleEntity role);

}
