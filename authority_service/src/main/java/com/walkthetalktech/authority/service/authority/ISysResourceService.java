package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.enums.ResourceType;
import com.walkthetalktech.authority.model.authority.RSResource;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;

public interface ISysResourceService {

	public List<SysResource> findSysResourceListByUserInfo(UserInfo userInfoParam); 
	
	public List<SysResource> findSysResourceListByRoleInfo(RoleInfo roleInfo,boolean isTreeExpended);
	
	public List<SysResource> findSysResourceListBySysResource(SysResource sysResource);
	
	public List<SysResource> findSysResourceListCascadeBySysResource(SysResource sysResource);
	
	public List<Long> findSysResourceIdListBySysResource(SysResource sysResource);
	
	public List<Long> findSysResourceIdListByRoleInfo(RoleInfo roleInfo);
	
	public boolean modifyRoleResourceByRoleInfoIdAndSysResourceIds(String sysResourceIds,Long roleInfoId);
	
	public List<SysResource> findSysResourceListByRoleInfoListAndSysResource(List<RoleInfo> roleInfoList,SysResource sysResourceParam);
}
