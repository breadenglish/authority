package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class Module extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String moduleName;
	
	private String modulePrefix;
	
	private String moduleDescription;
	
	private Long moduleType;
	
	private String createTime;
	
	private Boolean isRepeatLogin;
	
	private Integer maxLoginNum;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModuleName() {
		return moduleName;
	}


	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}


	public String getModulePrefix() {
		return modulePrefix;
	}


	public void setModulePrefix(String modulePrefix) {
		this.modulePrefix = modulePrefix;
	}


	public String getModuleDescription() {
		return moduleDescription;
	}


	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}


	public Long getModuleType() {
		return moduleType;
	}


	public void setModuleType(Long moduleType) {
		this.moduleType = moduleType;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public Boolean getIsRepeatLogin() {
		return isRepeatLogin;
	}


	public void setIsRepeatLogin(Boolean isRepeatLogin) {
		this.isRepeatLogin = isRepeatLogin;
	}


	public Integer getMaxLoginNum() {
		return maxLoginNum;
	}


	public void setMaxLoginNum(Integer maxLoginNum) {
		this.maxLoginNum = maxLoginNum;
	}


	@Override
	public String toString() {
		JSONObject jsonObject = JSONObject.fromObject(this);
		return jsonObject.toString();
	}
}
