package com.walkthetalktech.authority.dao.authority;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:authority/spring/spring-mybatis.xml"})*/
public class TestPermissionMapper {

	/*@Autowired
	private IPermissionMapper permissionMapper;*/
	
	
	/**
	 * 测试添加接口
	 */
	public void testInsertPermission(){
		/*Permission permission=new Permission();
		permission.setPermissionDescription("用户查看权限");
		permission.setPermissionPrefix("user:vew");
		permission.setPermissionName("用户视图");
		Long permissionId=permissionMapper.insertPermission(permission);
		System.out.println("插入后的id为:"+permissionId);
		System.out.println("插入后的结果为:"+permission);*/
	}
	
	
	public void testSelectPermissionByPK(){
		/*Long permissionId=2l;
		System.out.println("测试信息");
		Permission permission=permissionMapper.selectPermissionByPrimaryKey(permissionId);
		System.out.println("该主键对应的资源信息为:"+permission);*/
	}
	
	
	public void testUpdatePermission(){
		/*Long permissionId=2l;
		Permission permission=permissionMapper.selectPermissionByPrimaryKey(permissionId);
		permission.setPermissionDescription("用户可以查看视图啦");
		Integer result=permissionMapper.updatePermissionByPermission(permission);
		System.out.println("修改结果为:"+result);
		System.out.println("修改之后的bean:"+permission);*/
	}
	
	public void testDeletePermission(){
		/*Long permissionId=2l;
		System.out.println("删除结果:"+permissionMapper.deletePermissionByPrimaryKey(permissionId));
		Permission permission=permissionMapper.selectPermissionByPrimaryKey(permissionId);
		System.out.println("删除之后的这个bean:"+permission);*/
	}
}
