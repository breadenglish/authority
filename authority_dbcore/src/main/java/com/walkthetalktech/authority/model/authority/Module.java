package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class Module extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String moduleName;
	
	private String modulePrefix;
	
	private String moduleDescription;
	
	private Integer moduleType;

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

	public Integer getModuleType() {
		return moduleType;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}

	@Override
	public String toString() {
		JSONObject jsonObject = JSONObject.fromObject(this);
		jsonObject.remove("beginDate");
		jsonObject.remove("endDate");
		return jsonObject.toString();
	}
}
