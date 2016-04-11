package com.walkthetalktech.authority.service.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Module;

public interface IModuleService {

	public List<Module> findModuleListByModule(Module moduleParam);
	
	public Integer findModuleCountByModule(Module moduleParam);
	
	public Module saveModule(Module module);
	
	public Integer removeModifyByPrimaryKey(Long moduleId);
	
	public Boolean removeModuleByModuleIdArrayString(String moduleIdArrayString);
}
