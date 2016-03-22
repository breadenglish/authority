package com.walkthetalktech.authority.dao.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.RoleInfo;

public interface IRoleInfoMapper {
						
	public List<RoleInfo> selectRoleListByAuthorityId(Long authorityId);
	
	public List<RoleInfo> selectRoleInfoListByRoleInfo(RoleInfo roleInfo);
	
	public Integer selectRoleInfoCountByRoleInfo(RoleInfo roleInfo);
}
