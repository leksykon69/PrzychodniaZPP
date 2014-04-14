package pol.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.PermissionEntity;
import pol.permission.dao.PermissionDao;
import pol.permission.service.PermissionService;

@Service
public class PermissionServiceImpl extends
		AbstractServiceImpl<PermissionEntity> implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	@Override
	protected AbstractDao<PermissionEntity> getDao() {
		return permissionDao;
	}
}
