package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.RoleInfo;

public interface IRoleInfoService {
	
	public List<RoleInfo> findRoleInfoByUserAccount(String account);
	
	public List<RoleInfo> findRoleInfoByRoleInfo(RoleInfo roleInfo);
	
	public Integer findRoleInfoCountByRoleInfo(RoleInfo roleInfo);
	
	public Boolean removeRoleInfoListByPKArray(String roleInfoIds);
	
	public RoleInfo modifyRoleInfoByRoleInfo(RoleInfo roleInfo);
	
	public RoleInfo addRoleInfoByRoleInfo(RoleInfo roleInfo);
	
	public RoleInfo loadRoleInfoByPrimaryKey(Long roleInfoId);
}
