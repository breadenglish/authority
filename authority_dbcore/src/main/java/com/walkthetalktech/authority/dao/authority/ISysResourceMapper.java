package com.walkthetalktech.authority.dao.authority;

import java.util.List;
import java.util.Map;

import com.walkthetalktech.authority.model.authority.RSResource;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;

public interface ISysResourceMapper {
	
	public SysResource selectSysResourceByPrimaryKey(Long sysResourceId);

	public List<SysResource>  selectSysResourceListBySysResource(SysResource sysResource);
	
	public List<SysResource> selectSysResourceListByRoleIdAndSysResourceType(Map<String,Object> map);
	
	public List<SysResource> selectSysResourceListByRoleInfo(RoleInfo roleInfo);
	
	public List<SysResource> selectSysResourceListCascadeBySysResource(SysResource sysResource);
	
	public List<Long> selectSysResourceIdListByRoleInfoId(Long roleInfoId);
	
	public Integer deleteSysResourceRoleInfoByRoleInfoIdAndSysResourceId(Long id);
	
	public Map<String,Object> selectSysResourceRoleInfoByRoleInfoIdAndSysResourceId(Long roleInfoId,Long sysResourceId);
	
	public Integer insertSysResourceRoleInfoBySysResourceRoleInfo(Map<String,Object> sysResourceRoleInfo);
	
	
	public List<RSResource> selectRSResourceListByRoleInfo(RoleInfo roleInfo);
	
	public List<RSResource> selectRSResourceListByRSResource(RSResource rsresource);
	
}
