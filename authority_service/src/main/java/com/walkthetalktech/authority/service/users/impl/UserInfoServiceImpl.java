package com.walkthetalktech.authority.service.users.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.users.IUserInfoMapper;
import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.users.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private IUserInfoMapper userInfoMapper;

	@Override
	public List<UserInfo> findUserInfoList() {
		return userInfoMapper.selectUserInfoList();
	}

	@Override
	public UserInfo loadUserInfo(UserInfo userInfo) {
		return userInfoMapper.selectUserInfoByUserInfo(userInfo);
	}

	@Override
	public Integer findUserInfoCountByUserInfo(UserInfo userInfo) {
		return userInfoMapper.selectUserInfoCountByUserInfo(userInfo);
	}

}
