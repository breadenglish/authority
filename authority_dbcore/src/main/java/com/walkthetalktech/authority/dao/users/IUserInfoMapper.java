package com.walkthetalktech.authority.dao.users;

import java.util.List;

import com.walkthetalktech.authority.model.users.UserInfo;

public interface IUserInfoMapper {
	
	public List<UserInfo> selectUserInfoList();
	
	public UserInfo selectUserInfoByUserInfo(UserInfo userInfo);
}
