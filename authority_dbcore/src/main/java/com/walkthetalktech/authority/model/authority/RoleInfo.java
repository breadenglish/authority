package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;
import java.util.Date;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class RoleInfo  extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String roleName;
	
	private String rolePrefix;
	
	private Date createTime;
	
	private String roleDescription;
	
	private Boolean avaiable;
	
	private Boolean isDel;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRolePrefix() {
		return rolePrefix;
	}


	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getRoleDescription() {
		return roleDescription;
	}


	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}


	public Boolean getAvaiable() {
		return avaiable;
	}


	public void setAvaiable(Boolean avaiable) {
		this.avaiable = avaiable;
	}


	public Boolean getIsDel() {
		return isDel;
	}


	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}


	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		return jsonObject.toString();
	}

}
