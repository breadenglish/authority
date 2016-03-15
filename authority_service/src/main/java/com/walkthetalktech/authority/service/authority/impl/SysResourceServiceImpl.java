package com.walkthetalktech.authority.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.walkthetalktech.authority.dao.users.IUserInfoMapper;
import com.walkthetalktech.authority.enums.ResourceType;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.authority.ISysResourceService;

public class SysResourceServiceImpl implements ISysResourceService {
	
	@Autowired
	private IUserInfoMapper userInfoMapper;

	@Override
	public List<SysResource> findSysResourceByUserInfo(UserInfo userInfo, ResourceType resourceType) {
		// TODO Auto-generated method stub
		return null;
	}

}
