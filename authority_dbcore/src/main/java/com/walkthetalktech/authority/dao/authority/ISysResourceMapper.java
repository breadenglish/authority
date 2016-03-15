package com.walkthetalktech.authority.dao.authority;

import java.util.List;
import com.walkthetalktech.authority.model.authority.SysResource;

public interface ISysResourceMapper {
	public List<SysResource> selectSysResourceListByMenuSysResource(SysResource sysResource);
	
	public List<SysResource> selectSysResourceListByRoleId(Long roleId);
}
