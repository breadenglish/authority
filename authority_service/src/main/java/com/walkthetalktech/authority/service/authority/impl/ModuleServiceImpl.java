package com.walkthetalktech.authority.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walkthetalktech.authority.dao.authority.IModuleMapper;
import com.walkthetalktech.authority.model.authority.Module;
import com.walkthetalktech.authority.service.authority.IModuleService;
import com.walkthetalktech.authority.utils.DateUtils;

@Service("moduleService")
public class ModuleServiceImpl implements IModuleService {

	@Autowired
	private IModuleMapper moduleMapper;

	@Override
	public List<Module> findModuleListByModule(Module moduleParam) {
		return moduleMapper.selectModuleListByModule(moduleParam);
	}

	@Override
	public Integer findModuleCountByModule(Module moduleParam) {
		return moduleMapper.selectModuleCountByModule(moduleParam);
	}

	@Override
	public Module saveModule(Module module) {
		if (null == module.getId()) {
			module.setCreateTime(DateUtils.getDefaultCurrentTime());
			if (moduleMapper.insertModule(module) > 0) {
				return module;
			}
			return null;
		}
		if (moduleMapper.updateModule(module) > 0) {
			return module;
		}
		return null;
	}

	@Override
	public Integer removeModifyByPrimaryKey(Long moduleId) {
		return moduleMapper.deleteModuleByPrimaryKey(moduleId);
	}

	@Override
	public Boolean removeModuleByModuleIdArrayString(String moduleIdArrayString) {
		if (StringUtils.isBlank(moduleIdArrayString)) {
			return false;
		}
		String[] moduleIdArray = moduleIdArrayString.split(",");
		for (String moduleIdString : moduleIdArray) {
			if(moduleMapper.deleteModuleByPrimaryKey(Long.parseLong(moduleIdString))<=0){
				return false;
			}
		}
		return true;
	}

}
