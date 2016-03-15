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
	public List<SysResource> findSysResourceByUserInfo(UserInfo userInfoParam, ResourceType resourceType) {
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
			if(resourceType.equals(ResourceType.MENU)){
				sysResourceList=getMenuResourceList(sysResourceList, sysResourceFragmentList);
			}else{
				sysResourceList=getSysResourceList(sysResourceList, sysResourceFragmentList);
			}
		}
		if(sysResourceList.size()<=0){
			return null;
		}
		return sysResourceList;
	}

	private List<SysResource> getSysResourceList(List<SysResource> sysResourceList, List<SysResource> sysResourceFragmentList) {
		for (SysResource sysResource : sysResourceFragmentList) {
			if(sysResourceList.contains(sysResource)){
				continue;
			}
			sysResourceList.add(sysResource);
		}
		return sysResourceList;
	}

	private List<SysResource> getMenuResourceList(List<SysResource> sysResourceList, List<SysResource> sysResourceFragmentList) {
		for (SysResource sysResource : sysResourceFragmentList) {
			if(sysResourceList.contains(sysResource)){
				continue;
			}
			List<SysResource> menuResourceList=sysResourceMapper.selectSysResourceListByMenuSysResource(sysResource);
			for (SysResource menuResource : menuResourceList) {
				if(sysResourceList.contains(menuResource)){
					continue;
				}
				sysResourceList.add(menuResource);
			}
		}
		return sysResourceList;
	}
	
	
	

}
