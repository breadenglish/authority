package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class Authority extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Long userId;
	
	private Long moduleId;
	
	private Long deptId;
	
	private Integer authorityType;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getModuleId() {
		return moduleId;
	}



	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}



	public Long getDeptId() {
		return deptId;
	}



	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}



	public Integer getAuthorityType() {
		return authorityType;
	}



	public void setAuthorityType(Integer authorityType) {
		this.authorityType = authorityType;
	}



	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		jsonObject.remove("beginDate");
		jsonObject.remove("endDate");
		return jsonObject.toString();
	}
	
	
}
