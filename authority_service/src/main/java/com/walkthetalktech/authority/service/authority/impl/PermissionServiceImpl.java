package com.walkthetalktech.authority.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.IPermissionMapper;
import com.walkthetalktech.authority.model.authority.Permission;
import com.walkthetalktech.authority.service.authority.IPermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {
	
	@Autowired
	private IPermissionMapper permissionMapper;

	@Override
	public List<Permission> findPermissionListByPermission(Permission permission) {
		return permissionMapper.selectPermissionListByPermission(permission);
	}

	@Override
	public Integer removePermissionByPramaryKey(Long permissionId) {
		Integer result=0;
		Permission permission=permissionMapper.selectPermissionByPrimaryKey(permissionId);
		if(null!=permission){
			result=permissionMapper.deletePermissionByPrimaryKey(permissionId);
		}else{
			result=-1;
		}
		return result;
	}

	@Override
	public Long addPermissionByPermission(Permission permission) {
		return permissionMapper.insertPermission(permission);
	}

	@Override
	public Permission loadPermissionByPramaryKey(Long permissionId) {
		return permissionMapper.selectPermissionByPrimaryKey(permissionId);
	}

	@Override
	public Permission modifyPermissionByPermission(Permission permission) {
		if(this.loadPermissionByPramaryKey(permission.getId())!=null){
			permissionMapper.updatePermissionByPermission(permission);
			return permission;
		}
		return null;
	}

}
