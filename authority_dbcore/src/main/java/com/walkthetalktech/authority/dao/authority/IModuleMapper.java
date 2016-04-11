package com.walkthetalktech.authority.dao.authority;

import java.util.List;

import com.walkthetalktech.authority.model.authority.Module;

public interface IModuleMapper {

	public List<Module> selectModuleListByModule(Module module);
	
	public Integer selectModuleCountByModule(Module module);
	
	public Integer insertModule(Module module);
	
	public Integer updateModule(Module module);
	
	public Integer deleteModuleByPrimaryKey(Long moduleId);
}
