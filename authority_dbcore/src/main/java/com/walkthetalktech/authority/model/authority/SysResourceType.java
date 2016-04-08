package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

public class SysResourceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long sysResourceTypeId;
	
	private String sysResourceType;

	public Long getSysResourceTypeId() {
		return sysResourceTypeId;
	}

	public void setSysResourceTypeId(Long sysResourceTypeId) {
		this.sysResourceTypeId = sysResourceTypeId;
	}

	public String getSysResourceType() {
		return sysResourceType;
	}

	public void setSysResourceType(String sysResourceType) {
		this.sysResourceType = sysResourceType;
	}
}
