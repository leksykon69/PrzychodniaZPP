package pol.role.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.RoleEntity;
import pol.role.dao.RoleDao;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<RoleEntity> implements RoleDao {

	public RoleDaoImpl() {
		super(RoleEntity.class);
	}

}
