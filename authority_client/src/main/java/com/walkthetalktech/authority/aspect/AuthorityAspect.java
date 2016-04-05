package com.walkthetalktech.authority.aspect;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.walkthetalktech.authority.annotation.CheckRoles;

import net.sf.json.JSONObject;

@Component("loginAuthority")
@Aspect
public class AuthorityAspect {
	
	private static Logger logger = LoggerFactory.getLogger(AuthorityAspect.class);

	/**检查权限字符串user:create之类
	 * @return 将执行结果进行返回
	 */
	public JSONObject checkPermissions(){
		JSONObject jsonObject=null;
		return jsonObject;
	}
	
	
	
	/**检查是否拥有某个角色
	 * @return
	 */
	public JSONObject checkRoles(){
		JSONObject jsonObject=null;
		return jsonObject;
	}
	
	@Around("execution(* login*())&&@annotation(checkRoles))")
	public JSONObject checkLogin(ProceedingJoinPoint pjp,CheckRoles checkRoles) throws Throwable{
		String userName=null;//userInfo.getAccount();
		String password=null;//userInfo.getPassword();
		boolean isPermission=false;
		logger.info("AUTHORITY_SYSTEM------------------>登录权限验证");
		Subject currentUser=SecurityUtils.getSubject();
		logger.info("AUTHORITY_SYSTEM------------------>用户名:"+userName);
		logger.info("AUTHORITY_SYSTEM------------------>密码:"+password);
		logger.info("AUTHORITY_SYSTEM------------------>要求的角色:"+checkRoles.roles());
		UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
		currentUser.login(token);
		if(null!=checkRoles&&currentUser.isAuthenticated()){
			String[] rolesArray=checkRoles.roles();
			for (String role : rolesArray) {
				if(currentUser.isPermitted(role)){
					isPermission=true;
					break;
				}
			}
		}else{
			isPermission=true;
		}
		JSONObject jsonO=(JSONObject)pjp.proceed();
		if(!isPermission){
			logger.info("AUTHORITY_SYSTEM------------------>没有权限");
			jsonO.put("status", "2");
			jsonO.put("message", "没有权限");
		}else{
			logger.info("AUTHORITY_SYSTEM------------------>权限通过");
			jsonO.put("status", "1");
		}
		return jsonO;
	}
}
