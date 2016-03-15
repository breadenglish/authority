package com.walkthetalktech.authority.service.authority;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walkthetalktech.authority.enums.ResourceType;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:authority/spring/spring-mybatis.xml","classpath*:authority/spring/spring-authority.xml"})
public class TestSysResourceService {
	
	@Autowired
	private ISysResourceService sysResourceService;
	
	@Test
	public void testFindSysResourceByUserInfo(){
		UserInfo userInfoParam=new UserInfo();
		userInfoParam.setAccount("admin");
		List<SysResource> sysResourceList=sysResourceService.findSysResourceByUserInfo(userInfoParam, ResourceType.MENU);
		System.out.println("查询结果:"+sysResourceList);
	}
}
