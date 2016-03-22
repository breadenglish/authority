package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Permission;
import com.walkthetalktech.authority.model.users.UserInfo;

public interface IPermissionService {
	public List<Permission> findPermissionListByPermission(Permission permission);
	
	public Integer findPermissionCountByPermission(Permission permission);
	
	public Integer removePermissionByPramaryKey(Long permissionId);
	
	public Boolean removePermissionListByPKArray(String permissionIds);
	
	public Integer findPermissionCountByUserInfo(UserInfo userInfo);
	
	public Long addPermissionByPermission(Permission permission);
	
	public Permission loadPermissionByPramaryKey(Long permissionId);
	
	public Permission modifyPermissionByPermission(Permission permission);
}
