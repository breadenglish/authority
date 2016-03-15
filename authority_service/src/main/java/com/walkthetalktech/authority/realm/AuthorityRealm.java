package com.walkthetalktech.authority.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.walkthetalktech.authority.service.authority.IPermissionService;
import com.walkthetalktech.authority.service.users.IUserInfoService;

public class AuthorityRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("开始授权");
		String account=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roleSet = new HashSet<String>();
		roleSet.add("user:create");
		roleSet.add("user:view");
		info.setStringPermissions(roleSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的身份验证信息
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		if (StringUtils.isBlank(username)||!username.equals("accp")) {
			System.out.println("用户名不正确");
			throw new UnknownAccountException();
		}
		if (StringUtils.isBlank(password)||!password.equals("admin")) {
			System.out.println("密码不正确");
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
