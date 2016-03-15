package com.walkthetalktech.authority.dao.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Permission;

public interface IPermissionMapper {

	public Long insertPermission(Permission permission);
	
	public List<Permission> selectPermissionListByPermission(Permission permission);
	
	public Permission selectPermissionByPrimaryKey(Long permissionId);
	
	public Integer updatePermissionByPermission(Permission permission);
	
	public Integer deletePermissionByPrimaryKey(Long permissionId);
}
