package com.walkthetalktech.authority.dao.authority;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walkthetalktech.authority.model.authority.SysResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:authority/spring/spring-mybatis.xml"})
public class TestSysResourceMapper {

	@Autowired
	private ISysResourceMapper sysResourceMapper;
	
	
	public void testSelectMenu(){
		SysResource sysResource=new SysResource();
		sysResource.setId(1l);
		List<SysResource> sysResourceList=sysResourceMapper.selectSysResourceListByMenuSysResource(sysResource);
		System.out.println(sysResourceList);
	}
	
	public void testSelectMenuByRoleId(){
		List<SysResource> sysResourceList=sysResourceMapper.selectSysResourceListByRoleId(1l);
		System.out.println(sysResourceList);
	}
}
