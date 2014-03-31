package pol.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.BaseDao;
import pol.dao.MenuDao;
import pol.entity.MenuEntity;

@Repository
public class MenuDaoImpl extends BaseDao<MenuEntity, Long> implements
		MenuDao {

}
