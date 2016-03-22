package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;
import java.util.Date;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class Permission  extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private String permissionName;
	
	private String permissionPrefix;
	
	private String permissionDescription;
	
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionPrefix() {
		return permissionPrefix;
	}

	public void setPermissionPrefix(String permissionPrefix) {
		this.permissionPrefix = permissionPrefix;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		jsonObject.remove("beginDate");
		jsonObject.remove("endDate");
		return jsonObject.toString();
	}
	
	
	

}
