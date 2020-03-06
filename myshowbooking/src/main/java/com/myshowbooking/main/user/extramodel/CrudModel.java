package com.myshowbooking.main.user.extramodel;

public class CrudModel {
	
	private String createddate;
	private String createdby;
	private String deleteflag;
	private String updatedate;
	private String updateby;
	private String comment;
	
	public CrudModel(String createddate, String createdby, String deleteflag, String updatedate, String updateby,
			String comment) {
		super();
		this.createddate = createddate;
		this.createdby = createdby;
		this.deleteflag = deleteflag;
		this.updatedate = updatedate;
		this.updateby = updateby;
		this.comment = comment;
	}
	public CrudModel() {
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
