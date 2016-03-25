package com.walkthetalktech.authority.dao.authority;

import java.util.List;
import java.util.Map;

import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;

public interface ISysResourceMapper {
	/*public List<SysResource> selectSysResourceListByMenuSysResource(SysResource sysResource);*/
	public List<SysResource>  selectSysResourceListBySysResource(SysResource sysResource);
	
	public List<SysResource> selectSysResourceListByRoleIdAndSysResourceType(Map<String,Object> map);
	
	public List<SysResource> selectSysResourceListByRoleInfo(RoleInfo roleInfo);
}
