package com.walkthetalktech.authority.enums;

public enum ResourceType {
	BUTTON(2,"按钮"),
	MENU(1,"菜单"),
	OPERATE(0,"操作");
	ResourceType(Integer value,String text){
		this.value=value;
		this.text=text;
	}
	private final Integer value;
	private final String text;
	public Integer getValue() {
		return value;
	}
	public String getText() {
		return text;
	}
	
	
}
