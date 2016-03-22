package com.walkthetalktech.authority.model.common;

import java.util.Date;

public class BaseModel {
	
	
	
	private Integer rows;
	
	private Integer beginNum;
	
	private Date beginDate;
	
	private Date endDate;

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
