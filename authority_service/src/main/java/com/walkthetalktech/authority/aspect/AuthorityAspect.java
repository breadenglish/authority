package com.walkthetalktech.authority.aspect;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.walkthetalktech.authority.annotation.CheckPermissions;
import com.walkthetalktech.authority.model.users.UserInfo;

import net.sf.json.JSONObject;

@Component("loginAuthority")
@Aspect
public class AuthorityAspect {
	
	

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
	
	@Around("execution(* login*(com.walkthetalktech.authority.model.users.UserInfo))&&@annotation(checkPermissions)&&args(userInfo))")
	public JSONObject checkLogin(ProceedingJoinPoint pjp,CheckPermissions checkPermissions,UserInfo userInfo) throws Throwable{
		String userName=userInfo.getAccount();
		String password=userInfo.getPassword();
		boolean isPermission=false;
		System.out.println("权限验证");
		Subject currentUser=SecurityUtils.getSubject();
		System.out.println("用户名:"+userName);
		System.out.println("密码:"+password);
		System.out.println("要求的权限:"+checkPermissions.permissions());
		UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
		currentUser.login(token);
		if(null!=checkPermissions&&currentUser.isAuthenticated()){
			String[] permissionArray=checkPermissions.permissions();
			for (String permission : permissionArray) {
				if(currentUser.isPermitted(permission)){
					isPermission=true;
					break;
				}
			}
		}else{
			isPermission=true;
		}
		if(!isPermission){
			System.out.println("没有权限");
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("status", "2");
			return jsonObject;
		}else{
			System.out.println("权限通过");
			JSONObject jsonO=(JSONObject)pjp.proceed();
			return jsonO;
		}
	}
}
