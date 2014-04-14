package pol.menu.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.MenuEntity;
import pol.menu.dao.MenuDao;

@Repository
public class MenuDaoImpl extends AbstractDaoImpl<MenuEntity> implements
		MenuDao {

	public MenuDaoImpl() {
		super(MenuEntity.class);
	}

}
