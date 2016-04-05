package com.walkthetalktech.authority.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walkthetalktech.authority.aspect.AuthorityAspect;

public class AuthorityRealm extends AuthorizingRealm {
	
	private static Logger logger = LoggerFactory.getLogger(AuthorityAspect.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("AUTHORITY_SYSTEM------------------>开始授权.");
		String account=(String)principals.getPrimaryPrincipal();
		logger.info("AUTHORITY_SYSTEM------------------>用户账户:"+account);
		logger.info("AUTHORITY_SYSTEM------------------>用户角色列表:");
		Set<String> roleSet = new HashSet<String>();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(roleSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的身份验证信息
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		/*if (StringUtils.isBlank(username)||!username.equals("admin")) {
			logger.info("AUTHORITY_SYSTEM------------------>账户不正确");
			throw new UnknownAccountException();
		}
		if (StringUtils.isBlank(password)||!password.equals("hohoTECH123")) {
			logger.info("AUTHORITY_SYSTEM------------------>密码不正确");
			throw new IncorrectCredentialsException();
		}*/
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
