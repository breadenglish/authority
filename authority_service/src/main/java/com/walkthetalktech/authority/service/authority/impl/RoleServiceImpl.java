package com.walkthetalktech.authority.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.IRoleInfoMapper;
import com.walkthetalktech.authority.model.authority.Authority;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.service.authority.IAuthorityService;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;
import com.walkthetalktech.authority.service.authority.ISysResourceService;
import com.walkthetalktech.authority.utils.DateUtils;

import net.sf.json.JSONObject;

@Service("roleService")
public class RoleServiceImpl implements IRoleInfoService {
	
	@Autowired
	private IAuthorityService authorityService;
	
	@Autowired
	private IRoleInfoMapper roleInfoMapper;
	
	@Autowired
	private ISysResourceService sysResourceService;

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
	public List<RoleInfo>  findRoleSysResourceListByRoleInfo(RoleInfo roleInfoParam) {
		List<RoleInfo> resultRoleInfoList=new ArrayList<RoleInfo>();
		List<RoleInfo> roleInfoList = roleInfoMapper.selectRoleInfoListByRoleInfo(roleInfoParam);
		for (RoleInfo roleInfo : roleInfoList) {
			List<SysResource> sysResourceList=sysResourceService.findSysResourceListByRoleInfo(roleInfo, true);
			if(sysResourceList.size()>0){
				if(null==roleInfo.getSysResourceList()){
					roleInfo.setSysResourceList(new ArrayList<SysResource>());
				}
				roleInfo.getSysResourceList().addAll(sysResourceList);
			}
			resultRoleInfoList.add(roleInfo);
		}
		return resultRoleInfoList;
	}

	



}
