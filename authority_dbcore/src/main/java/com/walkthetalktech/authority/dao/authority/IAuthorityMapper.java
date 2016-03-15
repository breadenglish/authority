package com.walkthetalktech.authority.dao.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Authority;

public interface IAuthorityMapper {

	public List<Authority> selectAuthorityListByAuthority(Authority authority);
}
