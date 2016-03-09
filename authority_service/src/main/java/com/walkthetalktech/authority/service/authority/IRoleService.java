package com.walkthetalktech.authority.service.authority;

import com.walkthetalktech.authority.model.authority.Role;

public interface IRoleService {
	
	public Role addRole(Role role);
	
	public void removeRole(Long roleId);
	
	public void updateRole(Role role);
	
	public void findRoleList(Role role);
}
