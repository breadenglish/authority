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

import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;
import com.walkthetalktech.authority.service.authority.ISysResourceService;
import com.walkthetalktech.authority.service.users.IUserInfoService;

public class AuthorityRealm extends AuthorizingRealm {
	
	private static Logger logger = LoggerFactory.getLogger(AuthorityRealm.class);
	
	@Autowired
	private IRoleInfoService roleInfoService;
	
	@Autowired
	private ISysResourceService sysResourceService;
	
	@Autowired
	private IUserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("AUTHORITY_SYSTEM------------------>开始授权.");
		String account=(String)principals.getPrimaryPrincipal();
		logger.info("AUTHORITY_SYSTEM------------------>用户账户:"+account);
		List<RoleInfo> roleInfoList=roleInfoService.findRoleInfoByUserAccount(account);
		Set<String> roleSet = new HashSet<String>();
		for (RoleInfo roleInfo : roleInfoList) {
			roleSet.add(roleInfo.getRolePrefix());
		}
		UserInfo userInfoParam=new UserInfo();
		userInfoParam.setAccount(account);
		List<SysResource> sysResourceList=sysResourceService.findSysResourceListByUserInfo(userInfoParam);
		Set<String> permissionSet=new HashSet<String>();
		for (SysResource sysResource : sysResourceList) {
			permissionSet.add(sysResource.getSysResourcePrefix());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roleSet);
		info.setStringPermissions(permissionSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的身份验证信息
		String account = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		System.out.println("用户名:"+account);
		System.out.println("密码:"+password);
		UserInfo userInfoParam=new UserInfo();
		userInfoParam.setAccount(account);
		Integer userInfoCountByAccount=userInfoService.findUserInfoCountByUserInfo(userInfoParam);
		if(userInfoCountByAccount<=0){
			logger.info("AUTHORITY_SYSTEM------------------>账户不正确");
			throw new UnknownAccountException();
		}
		userInfoParam.setPassword(password);
		Integer userInfoCount=userInfoService.findUserInfoCountByUserInfo(userInfoParam);
		if(userInfoCount<=0){
			logger.info("AUTHORITY_SYSTEM------------------>密码不正确");
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(account, password, getName());
	}

}
