package com.walkthetalktech.authority.enums;

public enum ErrorMsg {
	NULL_USER(1,"没有用户");
	private  ErrorMsg(Integer status,String value){
		this.status=status;
		this.value=value;
	}
	private final Integer status;
	private final String value;

	public Integer getStatus() {
		return status;
	}
	public String getValue() {
		return value;
	}
}
