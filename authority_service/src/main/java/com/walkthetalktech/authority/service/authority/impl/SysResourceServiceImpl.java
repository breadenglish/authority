package com.walkthetalktech.authority.service.authority.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walkthetalktech.authority.dao.authority.ISysResourceMapper;
import com.walkthetalktech.authority.dao.users.IUserInfoMapper;
import com.walkthetalktech.authority.enums.ResourceType;
import com.walkthetalktech.authority.model.authority.RSResource;
import com.walkthetalktech.authority.model.authority.RoleInfo;
import com.walkthetalktech.authority.model.authority.SysResource;
import com.walkthetalktech.authority.model.users.UserInfo;
import com.walkthetalktech.authority.service.authority.IRoleInfoService;
import com.walkthetalktech.authority.service.authority.ISysResourceService;

@Service("sysResourceService")
public class SysResourceServiceImpl implements ISysResourceService {

	@Autowired
	private IUserInfoMapper userInfoMapper;

	@Autowired
	private IRoleInfoService roleInfoService;

	@Autowired
	private ISysResourceMapper sysResourceMapper;

	/* (non-Javadoc)
	 * @see com.walkthetalktech.authority.service.authority.ISysResourceService#findSysResourceListByUserInfo(com.walkthetalktech.authority.model.users.UserInfo)
	 * 根据用户信息查找用户所拥有的节点的父节点,比如用户拥有A下的a,则将A查出来
	 */
	@Override
	public List<SysResource> findSysResourceListByUserInfo(UserInfo userInfoParam) {
		UserInfo userInfo = userInfoMapper.selectUserInfoByUserInfo(userInfoParam);
		if (null == userInfo) {
			return null;
		}
		List<RoleInfo> roleInfoList=roleInfoService.findRoleInfoByUserAccount(userInfo.getAccount());
		List<SysResource> sysResourceList=new ArrayList<SysResource>();
		for (RoleInfo roleInfo : roleInfoList) {
			List<SysResource> hashSysResourceList=sysResourceMapper.selectSysResourceListByRoleInfo(roleInfo);
			for (SysResource sysResourceParam : hashSysResourceList) {
				if(sysResourceList.contains(sysResourceParam)){
					continue;
				}
				sysResourceList.add(sysResourceParam);
			}
		}
		List<SysResource> result=new ArrayList<SysResource>();
		result=assembleOnlyParentSysResourceList(sysResourceList, result);
		return result;
	}
	
	private List<SysResource> assembleOnlyParentSysResourceList(List<SysResource> hashSysResourceList,List<SysResource> sysResourceList){
		Map<Long,SysResource> sysResourceMap=new HashMap<Long,SysResource>();
		SysResource parent=null;
		for (SysResource sysResource : hashSysResourceList) {
			if(sysResourceMap.containsValue(sysResource)){
				continue;
			}else if(null!=sysResource.getResourceParentId()&&sysResource.getResourceParentId()>0){
				Long parengId=sysResource.getResourceParentId();
				parent=sysResourceMapper.selectSysResourceByPrimaryKey(parengId);
				if(null!=parent){
					sysResourceMap.put(parent.getId(), parent);
				}
			}else if(null!=sysResource.getResourceParentId()&&sysResource.getResourceParentId()==0){
				sysResourceMap.put(sysResource.getId(), sysResource);
			}
		}
		for (Long sysResourceId : sysResourceMap.keySet()) {
			sysResourceList.add(sysResourceMap.get(sysResourceId));
		}
		return sysResourceList;
	}

	@Override
	public List<SysResource> findSysResourceListBySysResource(SysResource sysResource) {
		return sysResourceMapper.selectSysResourceListBySysResource(sysResource);
	}

	/**
	 * 根据角色信息查询该角色所拥有的资源数据,
	 * @param roleInfo 角色信息
	 * @param isTreeExpended 是否按照树形结构将其包装,
	 * 比如a是A的子节点,1是a的子节点,如果isTreeExpended为true,则返回的数据应该为{"name":"A","children":[{"name":"a","children":[{"name":"1"}]}]},
	 * 并且会将子节点封装到父节点下
	 * 如果isTreeExpended为false,则返回的数据为[{"name":"A"},{"name":"a"},{"name":"1"}]
	 * @return
	 */
	@Override
	public List<SysResource> findSysResourceListByRoleInfo(RoleInfo roleInfo, boolean isTreeExpended) {
		List<SysResource> hashSysResourceList = sysResourceMapper.selectSysResourceListByRoleInfo(roleInfo);
		if (!isTreeExpended) {
			return hashSysResourceList;
		}
		List<SysResource> sysResourceList = new ArrayList<SysResource>();
		sysResourceList=assembleSysResourceList(hashSysResourceList, sysResourceList);
		return sysResourceList;
	}
	
	private List<SysResource> assembleSysResourceList(List<SysResource> hashSysResourceList, List<SysResource> sysResourceList) {
		Map<Long,SysResource> sysResourceMap=new HashMap<Long,SysResource>();
		SysResource parent=null;
		for (SysResource sysResource : hashSysResourceList) {
			if(null!=sysResource.getResourceParentId()&&sysResource.getResourceParentId()==0&&!sysResourceMap.containsValue(sysResource)){
				SysResource sysResourceParam=new SysResource();
				sysResourceParam.setResourceParentId(sysResource.getId());
				List<SysResource> children=sysResourceMapper.selectSysResourceListBySysResource(sysResourceParam);
				sysResource.setChildren(children);
				sysResourceMap.put(sysResource.getId(), sysResource);
				continue;
			}else if(null!=sysResource.getResourceParentId()&&sysResourceMap.containsKey(sysResource.getResourceParentId())){
				parent=sysResourceMap.get(sysResource.getResourceParentId());
			}else{
				Long parengId=sysResource.getResourceParentId();
				parent=sysResourceMapper.selectSysResourceByPrimaryKey(parengId);
			}
			if(null==parent.getChildren()){
				parent.setChildren(new ArrayList<SysResource>());
			}
			parent.getChildren().add(sysResource);
			sysResourceMap.put(parent.getId(), parent);
		}
		for (Long sysResourceId : sysResourceMap.keySet()) {
			sysResourceList.add(sysResourceMap.get(sysResourceId));
		}
		return sysResourceList;
	}

	@Override
	public List<SysResource> findSysResourceListCascadeBySysResource(SysResource sr) {
		if (null == sr) {
			sr = new SysResource();
			sr.setResourceParentId(0l);
		}
		List<SysResource> sysResourceList = sysResourceMapper.selectSysResourceListBySysResource(sr);
		List<SysResource> cascadeSysResourceList = new ArrayList<SysResource>();
		for (int i = 0; i < sysResourceList.size(); i++) {
			SysResource sysResource = sysResourceList.get(i);
			SysResource sysResourceParam = new SysResource();
			sysResourceParam.setResourceParentId(sysResource.getId());
			List<SysResource> children = sysResourceMapper.selectSysResourceListBySysResource(sysResourceParam);
			if (children.size() > 0) {
				sysResource.setChildren(children);
			}
			cascadeSysResourceList.add(sysResource);
		}
		if (cascadeSysResourceList.size() > 0) {
			return cascadeSysResourceList;
		}
		return null;
	}

	@Override
	public List<Long> findSysResourceIdListBySysResource(SysResource sysResourceParam) {
		List<Long> sysResourceIdList = new ArrayList<Long>();
		List<SysResource> sysResourceList = sysResourceMapper.selectSysResourceListBySysResource(sysResourceParam);
		for (SysResource sysResource : sysResourceList) {
			sysResourceIdList.add(sysResource.getId());
		}
		return sysResourceIdList;
	}

	@Override
	public List<Long> findSysResourceIdListByRoleInfo(RoleInfo roleInfo) {
		List<Long> sysResourceIdList = new ArrayList<Long>();
		List<SysResource> sysResourceList = sysResourceMapper.selectSysResourceListByRoleInfo(roleInfo);
		for (SysResource sysResource : sysResourceList) {
			sysResourceIdList.add(sysResource.getId());
		}
		return sysResourceIdList;
	}

	@Transactional
	@Override
	public boolean modifyRoleResourceByRoleInfoIdAndSysResourceIds(String sysResourceIds, Long roleInfoId) {
		String[] sysResourceIdArray = sysResourceIds.split(",");

		List<Long> sysResourceIdList = new ArrayList<Long>();
		for (String sysResourceIdString : sysResourceIdArray) {
			sysResourceIdList.add(Long.parseLong(sysResourceIdString));
		}
		List<Long> resourceIdList = sysResourceMapper.selectSysResourceIdListByRoleInfoId(roleInfoId);
		for (Long sysResourceId : resourceIdList) {
			if (null != sysResourceIdList && !sysResourceIdList.contains(sysResourceId)) {
				Map<String, Object> sysResourceRoleInfo = sysResourceMapper
						.selectSysResourceRoleInfoByRoleInfoIdAndSysResourceId(roleInfoId, sysResourceId);
				boolean isOk = sysResourceMapper.deleteSysResourceRoleInfoByRoleInfoIdAndSysResourceId(
						(Long) sysResourceRoleInfo.get("id")) > 0;
				if (!isOk) {
					throw new RuntimeException("出异常了,请检查程序" + sysResourceRoleInfo.toString());
				}
			}
			if (sysResourceIdList.contains(sysResourceId)) {
				sysResourceIdList.remove(sysResourceId);
			}
		}
		for (Long resourceId : sysResourceIdList) {
			Map<String, Object> sysResourceRoleInfo = new HashMap<String, Object>();
			sysResourceRoleInfo.put("roleInfoId", roleInfoId);
			sysResourceRoleInfo.put("sysResourceId", resourceId);
			sysResourceRoleInfo.put("permissions", "(NULL)");
			boolean isOk = sysResourceMapper.insertSysResourceRoleInfoBySysResourceRoleInfo(sysResourceRoleInfo) > 0;
			if (!isOk) {
				throw new RuntimeException("出异常了,请检查程序" + sysResourceRoleInfo.toString());
			}
		}
		return true;
	}

	@Override
	public List<SysResource> findSysResourceListByRoleInfoListAndSysResource(List<RoleInfo> roleInfoList,
			SysResource sysResourceParam) {
		List<SysResource> sysResourceList=new ArrayList<SysResource>();
		for (RoleInfo roleInfo : roleInfoList) {
			RSResource rsresource=new RSResource();
			rsresource.setRoleInfoId(roleInfo.getId());
			rsresource.setSysResource(sysResourceParam);
			List<RSResource> rsResourceList=sysResourceMapper.selectRSResourceListByRSResource(rsresource);
			for (RSResource rsr : rsResourceList) {
				sysResourceList.add(rsr.getSysResource());
			}
		}
		return sysResourceList;
	}
}
