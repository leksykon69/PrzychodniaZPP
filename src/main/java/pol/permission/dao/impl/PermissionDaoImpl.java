package pol.permission.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.PermissionEntity;
import pol.permission.dao.PermissionDao;

@Repository
public class PermissionDaoImpl extends AbstractDaoImpl<PermissionEntity>
		implements PermissionDao {

	public PermissionDaoImpl() {
		super(PermissionEntity.class);
	}

}
