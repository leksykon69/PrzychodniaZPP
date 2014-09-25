package pol.menu.dao;

import java.util.List;

import pol.abstractDao.AbstractDao;
import pol.entity.MenuEntity;
import pol.entity.RoleEntity;


public interface MenuDao extends AbstractDao<MenuEntity> {
	
	List<MenuEntity> findByRoles(RoleEntity role);

}
