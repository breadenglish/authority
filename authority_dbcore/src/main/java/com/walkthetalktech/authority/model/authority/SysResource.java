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
	
	private String resourceName;
	
	private String resourcePrefix;
	
	private String resourceLink;
	
	private Integer resourceType;
	
	private Integer resourceSort;
	
	private Long resourceParentId;
	
	private String resourceDescription;
	
	private Date createTime;
	
	private Boolean avaiable;
	
	private Boolean isDel;
	
	private SysResource parentSysResource;

	private List<SysResource> childResourceList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourcePrefix() {
		return resourcePrefix;
	}

	public void setResourcePrefix(String resourcePrefix) {
		this.resourcePrefix = resourcePrefix;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
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
	
	public List<SysResource> getChildResourceList() {
		return childResourceList;
	}

	public void setChildResourceList(List<SysResource> childResourceList) {
		this.childResourceList = childResourceList;
	}
	
	public SysResource getParentSysResource() {
		return parentSysResource;
	}

	public void setParentSysResource(SysResource parentSysResource) {
		this.parentSysResource = parentSysResource;
	}

	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}

	
}
