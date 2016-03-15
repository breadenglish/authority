package com.walkthetalktech.authority.model.users;

import java.io.Serializable;
import java.util.Date;

import com.walkthetalktech.authority.model.common.BaseModel;

import net.sf.json.JSONObject;

public class UserInfo extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private String account;
	
	private String userName;
	
	private String password;
	
	private String salt;
	
	private Integer status;
	
	private Date createTime;
	
	private Boolean isDel;
	
	private Integer userType;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Boolean getIsDel() {
		return isDel;
	}



	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}



	public Integer getUserType() {
		return userType;
	}



	public void setUserType(Integer userType) {
		this.userType = userType;
	}



	@Override
	public String toString() {
		JSONObject jsonObject=JSONObject.fromObject(this);
		return jsonObject.toString();
	}
	
	

}
