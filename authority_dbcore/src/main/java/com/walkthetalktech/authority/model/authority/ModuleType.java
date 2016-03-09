package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class ModuleType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long moduleType;
	
	private String moduleTypeName;
	
	private String moduleDescription;

	public Long getModuleType() {
		return moduleType;
	}

	public void setModuleType(Long moduleType) {
		this.moduleType = moduleType;
	}

	public String getModuleTypeName() {
		return moduleTypeName;
	}

	public void setModuleTypeName(String moduleTypeName) {
		this.moduleTypeName = moduleTypeName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		return jsonObject.toString();
	}
	
	
	

}
