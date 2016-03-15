package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.RoleInfo;

public interface IRoleInfoService {
	
	public List<RoleInfo> findRoleInfoByUserAccount(String account);
}
