package com.walkthetalktech.authority.service.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.users.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Override
	public List<UserInfo> findUserInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

}
