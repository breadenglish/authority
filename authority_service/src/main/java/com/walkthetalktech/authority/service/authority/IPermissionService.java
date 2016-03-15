package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Permission;

public interface IPermissionService {
	public List<Permission> findPermissionListByPermission(Permission permission);
	
	public Integer removePermissionByPramaryKey(Long permissionId);
	
	public Long addPermissionByPermission(Permission permission);
	
	public Permission loadPermissionByPramaryKey(Long permissionId);
	
	public Permission modifyPermissionByPermission(Permission permission);
}
