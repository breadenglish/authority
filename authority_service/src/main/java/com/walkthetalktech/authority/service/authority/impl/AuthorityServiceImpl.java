package com.walkthetalktech.authority.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.IAuthorityMapper;
import com.walkthetalktech.authority.dao.users.IUserInfoMapper;
import com.walkthetalktech.authority.model.authority.Authority;
import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.authority.IAuthorityService;

@Service("authorityService")
public class AuthorityServiceImpl implements IAuthorityService {

	@Autowired
	private IAuthorityMapper authorityMapper;
	
	@Autowired
	private IUserInfoMapper userInfoMapper;
	
	@Override
	public List<Authority> findAuthorityByUserAccount(String account) {
		UserInfo userInfoParam=new UserInfo();
		userInfoParam.setAccount(account);
		UserInfo userInfo =userInfoMapper.selectUserInfoByUserInfo(userInfoParam);
		if(null==userInfo){
			return null;
		}
		Authority authorityParam=new Authority();
		authorityParam.setUserId(userInfo.getId());
		List<Authority> authorityList=authorityMapper.selectAuthorityListByAuthority(authorityParam);
		if(null==authorityList||authorityList.size()==0){
			return null;
		}
		return authorityList;
	}

}
