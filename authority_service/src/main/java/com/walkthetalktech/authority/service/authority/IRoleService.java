package com.walkthetalktech.authority.service.authority;

import com.walkthetalktech.authority.model.authority.RoleInfo;

public interface IRoleService {
	
	public RoleInfo addRole(RoleInfo roleInfo);
	
	public void removeRole(Long roleId);
	
	public void updateRole(RoleInfo roleInfo);
	
	public void findRoleList(RoleInfo roleInfo);
}
