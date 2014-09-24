package pol.role.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, String> getRoleComboList(boolean b) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		if (b) {
			result.put("", "");
		}
		List<RoleEntity> roles = roleDao.findAll();
		for (RoleEntity role : roles) {
			result.put(role.getId().toString(), role.getName());
		}
		return result;
	}
}
