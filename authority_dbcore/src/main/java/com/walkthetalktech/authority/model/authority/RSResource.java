package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class RSResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long rsrId;
	
	private Long roleInfoId;
	
	private SysResource sysResource;
	
	private String permissionIds;
	
	public Long getRsrId() {
		return rsrId;
	}

	public void setRsrId(Long rsrId) {
		this.rsrId = rsrId;
	}

	public SysResource getSysResource() {
		return sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}

	public Long getRoleInfoId() {
		return roleInfoId;
	}

	public void setRoleInfoId(Long roleInfoId) {
		this.roleInfoId = roleInfoId;
	}

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}

	@Override
	public String toString() {
		return new JSONObject().fromObject(this).toString();
	}
	
	
}
