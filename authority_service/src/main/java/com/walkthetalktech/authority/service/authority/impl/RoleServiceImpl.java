package com.walkthetalktech.authority.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.IRoleInfoMapper;
import com.walkthetalktech.authority.model.authority.Authority;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.service.authority.IAuthorityService;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;

@Service("roleService")
public class RoleServiceImpl implements IRoleInfoService {
	
	@Autowired
	private IAuthorityService authorityService;
	
	@Autowired
	private IRoleInfoMapper roleInfoMapper;

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



}
