package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.enums.ResourceType;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;

public interface ISysResourceService {

	public List<SysResource> findSysResourceListByUserInfo(UserInfo userInfoParam,ResourceType resourceType); 
	
	public List<SysResource> findSysResourceListByRoleInfo(RoleInfo roleInfo,boolean isCascade);
	
	public List<SysResource> findSysResourceListBySysResource(SysResource sysResource);
}
