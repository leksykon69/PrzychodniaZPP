package pol.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.RoleEntity;
import pol.role.dao.RoleDao;
import pol.role.service.RoleService;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<RoleEntity> implements
		RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	protected AbstractDao<RoleEntity> getDao() {
		return roleDao;
	}
}
