package com.walkthetalktech.authority.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.IRoleInfoMapper;
import com.walkthetalktech.authority.dao.authority.ISysResourceMapper;
import com.walkthetalktech.authority.model.authority.Authority;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.service.authority.IAuthorityService;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;
import com.walkthetalktech.authority.utils.DateUtils;

import net.sf.json.JSONObject;

@Service("roleService")
public class RoleServiceImpl implements IRoleInfoService {
	
	@Autowired
	private IAuthorityService authorityService;
	
	@Autowired
	private IRoleInfoMapper roleInfoMapper;
	
	@Autowired
	private ISysResourceMapper sysResourceMapper;

	@Override
	public List<RoleInfo> findRoleInfoByUserAccount(String account) {
		List<Authority> authorityList=authorityService.findAuthorityByUserAccount(account);
		if(null==authorityList){
			return null;
		}
		List<RoleInfo> roleInfoList=new ArrayList<RoleInfo>();
		for (Authority authority : authorityList) {
			List<RoleInfo> roleInfoArray=roleInfoMapper.selectRoleListByAuthorityId(authority.getId());
			for (RoleInfo roleInfo : roleInfoArray) {
				if(roleInfoList.contains(roleInfo)){
					continue;
				}
				roleInfoList.add(roleInfo);
			}
		}
		if(roleInfoList.size()==0){
			return null;
		}
		return roleInfoList;
	}

	@Override
	public List<RoleInfo> findRoleInfoByRoleInfo(RoleInfo roleInfo) {
		List<RoleInfo> roleInfoList=roleInfoMapper.selectRoleInfoListByRoleInfo(roleInfo);
		if(null!=roleInfoList&&roleInfoList.size()>0){
			return roleInfoList;
		}
		return null;
	}

	@Override
	public Integer findRoleInfoCountByRoleInfo(RoleInfo roleInfo) {
		return roleInfoMapper.selectRoleInfoCountByRoleInfo(roleInfo);
	}

	@Override
	public Boolean removeRoleInfoListByPKArray(String roleInfoIds) {
		String[] roleInfoIdArray=roleInfoIds.split(",");
		boolean isSuccess=true;
		for(String roleInfoId : roleInfoIdArray){
			Integer result=roleInfoMapper.deleteRoleInfoByPrimaryKey(Long.parseLong(roleInfoId));
			if(result<=0){
				isSuccess=false;
				break;
			}
		}
		return isSuccess;
	}

	@Override
	public RoleInfo modifyRoleInfoByRoleInfo(RoleInfo roleInfo) {
		if(null!=this.loadRoleInfoByPrimaryKey(roleInfo.getId())){
			int result=roleInfoMapper.updateRoleInfoByRoleInfo(roleInfo);
			if(result>0){
				return roleInfo;
			}
		}
		return null;
	}

	@Override
	public Long addRoleInfoByRoleInfo(RoleInfo roleInfo) {
		if(StringUtils.isBlank(roleInfo.getCreateTime())){
			roleInfo.setCreateTime(DateUtils.getCurrentTime("yyyy-MM-dd hh:mm:ss"));
		}
		return roleInfoMapper.insertRoleInfoByRoleInfo(roleInfo);
	}

	@Override
	public RoleInfo loadRoleInfoByPrimaryKey(Long roleInfoId) {
		return roleInfoMapper.loadRoleInfoByPrimaryKey(roleInfoId);
	}

	@Override
	public List<JSONObject> findRoleSysResourceListByRoleInfo(RoleInfo roleInfoParam) {
		List<JSONObject> jsonObjectList=new ArrayList<JSONObject>();
		List<RoleInfo> roleInfoList = roleInfoMapper.selectRoleInfoListByRoleInfo(roleInfoParam);
		for (RoleInfo roleInfo : roleInfoList) {
			JSONObject roleInfoJSONObject=new JSONObject();
			roleInfoJSONObject.put("id", roleInfo.getId());
			roleInfoJSONObject.put("name", roleInfo.getRoleName());
			roleInfoJSONObject.put("prefix", roleInfo.getRolePrefix());
			roleInfoJSONObject.put("roleDescription", roleInfo.getRoleDescription());
			List<SysResource> sysResourceList=sysResourceMapper.selectSysResourceListByRoleInfo(roleInfo);
			List<JSONObject> children=new ArrayList<JSONObject>();
			for (SysResource sysResource : sysResourceList) {
				JSONObject child=new JSONObject();
				child.put("id", sysResource.getId());
				child.put("name", sysResource.getSysResourceName());
				child.put("prefix", sysResource.getSysResourcePrefix());
				child.put("sysResourceDescription", sysResource.getResourceDescription());
				SysResource param=new SysResource();
				param.setResourceParentId(sysResource.getId());
				List<SysResource> childSysResourceList=sysResourceMapper.selectSysResourceListBySysResource(param);
				List<JSONObject> chList=new ArrayList<JSONObject>();
				for (SysResource ch : childSysResourceList) {
					JSONObject json=new JSONObject();
					json.put("id", ch.getId());
					json.put("name", ch.getSysResourceName());
					json.put("prefix", ch.getSysResourcePrefix());
					json.put("sysResourceDescription", ch.getResourceDescription());
					chList.add(json);
				}
				
				if(chList.size()>0){
					child.put("state", "closed");
					child.put("children", chList);
				}
				
				children.add(child);
			}
			if(children.size()>0){
				roleInfoJSONObject.put("state", "closed");
				roleInfoJSONObject.put("children", children);
			}
			jsonObjectList.add(roleInfoJSONObject);
		}
		return jsonObjectList;
	}

	



}
