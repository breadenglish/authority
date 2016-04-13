package com.walkthetalktech.authority.service.users;

import java.util.List;

import com.walkthetalktech.authority.model.users.UserInfo;

public interface IUserInfoService {
	
	public UserInfo loadUserInfo(UserInfo userInfo);
	
	public Integer findUserInfoCountByUserInfo(UserInfo userInfo);

	public List<UserInfo> findUserInfoList();
}
