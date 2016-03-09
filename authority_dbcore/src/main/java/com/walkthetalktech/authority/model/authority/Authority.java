package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authorityName;
	
	private String authorityPrefix;
	
	private String authorityDescription;

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityPrefix() {
		return authorityPrefix;
	}

	public void setAuthorityPrefix(String authorityPrefix) {
		this.authorityPrefix = authorityPrefix;
	}

	public String getAuthorityDescription() {
		return authorityDescription;
	}

	public void setAuthorityDescription(String authorityDescription) {
		this.authorityDescription = authorityDescription;
	}

	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		return jsonObject.toString();
	}
	
	
}
