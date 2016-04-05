package com.walkthetalktech.authority.model.authority;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class SysResource extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String sysResourceName;
	
	private String sysResourcePrefix;
	
	private String resourceLink;
	
	private Integer resourceType;
	
	private Integer resourceSort;
	
	private Long resourceParentId;
	
	private String resourceDescription;
	
	private String createTime;
	
	private Boolean avaiable;
	
	private Boolean isDel;
	
	private SysResource parentSysResource;

	private List<SysResource> children;
	
	private String resourceIcon;

	public String getResourceIcon() {
		return resourceIcon;
	}

	public void setResourceIcon(String resourceIcon) {
		this.resourceIcon = resourceIcon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSysResourceName() {
		return sysResourceName;
	}

	public void setSysResourceName(String sysResourceName) {
		this.sysResourceName = sysResourceName;
	}

	public String getSysResourcePrefix() {
		return sysResourcePrefix;
	}

	public void setSysResourcePrefix(String sysResourcePrefix) {
		this.sysResourcePrefix = sysResourcePrefix;
	}

	public List<SysResource> getChildren() {
		return children;
	}

	public void setChildren(List<SysResource> children) {
		this.children = children;
	}

	public String getResourceLink() {
		return resourceLink;
	}

	public void setResourceLink(String resourceLink) {
		this.resourceLink = resourceLink;
	}

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getResourceSort() {
		return resourceSort;
	}

	public void setResourceSort(Integer resourceSort) {
		this.resourceSort = resourceSort;
	}

	public Long getResourceParentId() {
		return resourceParentId;
	}

	public void setResourceParentId(Long resourceParentId) {
		this.resourceParentId = resourceParentId;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	
	
	
	public SysResource getParentSysResource() {
		return parentSysResource;
	}

	public void setParentSysResource(SysResource parentSysResource) {
		this.parentSysResource = parentSysResource;
	}

	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		return jsonObject.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysResource other = (SysResource) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDel == null) {
			if (other.isDel != null)
				return false;
		} else if (!isDel.equals(other.isDel))
			return false;
		if (resourceDescription == null) {
			if (other.resourceDescription != null)
				return false;
		} else if (!resourceDescription.equals(other.resourceDescription))
			return false;
		if (resourceIcon == null) {
			if (other.resourceIcon != null)
				return false;
		} else if (!resourceIcon.equals(other.resourceIcon))
			return false;
		if (resourceLink == null) {
			if (other.resourceLink != null)
				return false;
		} else if (!resourceLink.equals(other.resourceLink))
			return false;
		if (resourceParentId == null) {
			if (other.resourceParentId != null)
				return false;
		} else if (!resourceParentId.equals(other.resourceParentId))
			return false;
		if (resourceType == null) {
			if (other.resourceType != null)
				return false;
		} else if (!resourceType.equals(other.resourceType))
			return false;
		if (sysResourceName == null) {
			if (other.sysResourceName != null)
				return false;
		} else if (!sysResourceName.equals(other.sysResourceName))
			return false;
		if (sysResourcePrefix == null) {
			if (other.sysResourcePrefix != null)
				return false;
		} else if (!sysResourcePrefix.equals(other.sysResourcePrefix))
			return false;
		return true;
	}

	
	
	
	


}
