package pol.role.service;

import java.util.Map;

import pol.abstractService.AbstractService;
import pol.entity.RoleEntity;

public interface RoleService extends AbstractService<RoleEntity> {

	Map<String, String> getRoleComboList(boolean b);
}
