package com.walkthetalktech.authority.service.authority.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.ISysResourceMapper;
import com.walkthetalktech.authority.dao.users.IUserInfoMapper;
import com.walkthetalktech.authority.enums.ResourceType;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;
import com.walkthetalktech.authority.service.authority.ISysResourceService;

@Service("sysResourceService")
public class SysResourceServiceImpl implements ISysResourceService {
	
	@Autowired
	private IUserInfoMapper userInfoMapper;
	
	@Autowired
	private IRoleInfoService roleInfoService;
	
	@Autowired
	private ISysResourceMapper sysResourceMapper;
	
	@Override
	public List<SysResource> findSysResourceListByUserInfo(UserInfo userInfoParam, ResourceType resourceType) {
		UserInfo userInfo=userInfoMapper.selectUserInfoByUserInfo(userInfoParam);
		if(null==userInfo){
			return null;
		}
		
		Map<String,Object> resourceParam=new HashMap<String,Object>();
		resourceParam.put("sysResourceType", resourceType.getValue());
		
		List<SysResource> sysResourceList=new ArrayList<SysResource>();
		
		List<RoleInfo> roleInfoList=roleInfoService.findRoleInfoByUserAccount(userInfo.getAccount());
		for (RoleInfo roleInfo : roleInfoList) {
			resourceParam.put("roleInfoId", roleInfo.getId());
			List<SysResource> sysResourceFragmentList=sysResourceMapper.selectSysResourceListByRoleIdAndSysResourceType(resourceParam);
			for (SysResource sysResource : sysResourceFragmentList) {
				if(sysResourceList.contains(sysResource)){
					continue;
				}
				sysResourceList.add(sysResource);
			}
		}
		if(sysResourceList.size()<=0){
			return null;
		}
		return sysResourceList;
	}

	@Override
	public List<SysResource> findSysResourceListBySysResource(SysResource sysResource) {
		return sysResourceMapper.selectSysResourceListBySysResource(sysResource);
	}
	
	
	

}
