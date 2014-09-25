package pol.menu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.MenuEntity;
import pol.entity.RoleEntity;
import pol.menu.dao.MenuDao;

@Repository
public class MenuDaoImpl extends AbstractDaoImpl<MenuEntity> implements
		MenuDao {

	public MenuDaoImpl() {
		super(MenuEntity.class);
	}

	public List<MenuEntity> findByRoles(RoleEntity role) {
		return Lists.newArrayList();
	}

}
