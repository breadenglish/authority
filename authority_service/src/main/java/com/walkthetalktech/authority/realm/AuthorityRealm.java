package com.walkthetalktech.authority.realm;

import java.util.HashSet;
import java.util.List;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.walkthetalktech.authority.aspect.AuthorityAspect;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;
import com.walkthetalktech.authority.service.users.IUserInfoService;

public class AuthorityRealm extends AuthorizingRealm {
	
	private static Logger logger = LoggerFactory.getLogger(AuthorityAspect.class);
	
	@Autowired
	private IRoleInfoService roleInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("AUTHORITY_SYSTEM------------------>开始授权.");
		String account=(String)principals.getPrimaryPrincipal();
		logger.info("AUTHORITY_SYSTEM------------------>用户账户:"+account);
		List<RoleInfo> roleInfoList=roleInfoService.findRoleInfoByUserAccount(account);
		logger.info("AUTHORITY_SYSTEM------------------>用户角色列表:"+roleInfoList);
		Set<String> roleSet = new HashSet<String>();
		
		if(null!=roleInfoList){
			for (RoleInfo roleInfo : roleInfoList) {
				roleSet.add(roleInfo.getRolePrefix());
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(roleSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的身份验证信息
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		if (StringUtils.isBlank(username)||!username.equals("admin")) {
			logger.info("AUTHORITY_SYSTEM------------------>账户不正确");
			throw new UnknownAccountException();
		}
		if (StringUtils.isBlank(password)||!password.equals("hohoTECH123")) {
			logger.info("AUTHORITY_SYSTEM------------------>密码不正确");
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
