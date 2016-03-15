package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Authority;

public interface IAuthorityService {
	public List<Authority> findAuthorityByUserAccount(String account);
}
