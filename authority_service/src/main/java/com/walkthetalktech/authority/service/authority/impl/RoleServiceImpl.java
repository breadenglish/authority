package com.walkthetalktech.authority.service.authority.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.users.IUserInfoMapper;
import com.walkthetalktech.authority.model.authority.Role;
import com.walkthetalktech.authority.service.authority.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Override
	public Role addRole(Role role) {
		System.out.println("进入到Service的方法了");
		return null;
	}

	@Override
	public void removeRole(Long roleId) {

	}

	@Override
	public void updateRole(Role role) {

	}

	@Override
	public void findRoleList(Role role) {
		// TODO Auto-generated method stub
		
	}

}
