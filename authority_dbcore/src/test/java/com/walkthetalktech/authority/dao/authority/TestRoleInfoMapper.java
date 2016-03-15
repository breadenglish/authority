package com.walkthetalktech.authority.dao.authority;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walkthetalktech.authority.model.authority.RoleInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:authority/spring/spring-mybatis.xml"})
public class TestRoleInfoMapper {
	
	@Autowired
	private IRoleInfoMapper roleInfoMapper;
	
	@Test
	public void testSelectRoleListByAuthorityId(){
		Long authorityId=1l;
		List<RoleInfo> roleInfoList=roleInfoMapper.selectRoleListByAuthorityId(authorityId);
		System.out.println(roleInfoList);
	}
}
