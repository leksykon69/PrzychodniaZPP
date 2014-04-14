package pol.menu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.MenuEntity;
import pol.menu.dao.MenuDao;
import pol.menu.service.MenuService;

@Service
public class MenuServiceImpl extends AbstractServiceImpl<MenuEntity> implements
		MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	protected AbstractDao<MenuEntity> getDao() {
		return menuDao;
	}
}
