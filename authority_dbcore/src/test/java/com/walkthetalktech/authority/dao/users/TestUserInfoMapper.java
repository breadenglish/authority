package com.walkthetalktech.authority.dao.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walkthetalktech.authority.model.users.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:authority/spring/spring-mybatis.xml"})
public class TestUserInfoMapper {

	@Autowired
	private IUserInfoMapper userInfoMapper;
	
	
	@Test
	public void testSelectUserInfoByAccount(){
		UserInfo userInfoParam=new UserInfo();
		/*userInfoParam.setAccount("admin");*/
		userInfoParam.setUserName("管理");
		UserInfo userInfo=userInfoMapper.selectUserInfoByUserInfo(userInfoParam);
		System.out.println(userInfo);
	}
}
