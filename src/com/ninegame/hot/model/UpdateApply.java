package com.ninegame.hot.model;

public class UpdateApply {

	private int id;
	
	private UserAccount submitUser;
	
	private Project project;
	
	private UserAccount auditUser;
	
	private byte auditState;
	
	private byte updateState;
	
	private String updateTime;
	
	private String auditTime;
	
	private String submitTime;
	
	private String remark;
	
	private String auditReason;
	
	private String curVer;
	
	private String destVer;
	
	private String clientCharger;
	
	private String serverCharger;
	
	private String wcCharger;
	
	private String testCharger;
	
	private String uiCharger;
	
	private String masterCharger;
	
	private String hopeDate;

	public String getCurVer() {
		return curVer;
	}

	public void setCurVer(String curVer) {
		this.curVer = curVer;
	}

	public String getDestVer() {
		return destVer;
	}

	public void setDestVer(String destVer) {
		this.destVer = destVer;
	}

	public String getClientCharger() {
		return clientCharger;
	}

	public void setClientCharger(String clientCharger) {
		this.clientCharger = clientCharger;
	}

	public String getServerCharger() {
		return serverCharger;
	}

	public void setServerCharger(String serverCharger) {
		this.serverCharger = serverCharger;
	}

	public String getWcCharger() {
		return wcCharger;
	}

	public void setWcCharger(String wcCharger) {
		this.wcCharger = wcCharger;
	}

	public String getTestCharger() {
		return testCharger;
	}

	public void setTestCharger(String testCharger) {
		this.testCharger = testCharger;
	}

	public String getUiCharger() {
		return uiCharger;
	}

	public void setUiCharger(String uiCharger) {
		this.uiCharger = uiCharger;
	}

	public String getMasterCharger() {
		return masterCharger;
	}

	public void setMasterCharger(String masterCharger) {
		this.masterCharger = masterCharger;
	}

	public String getHopeDate() {
		return hopeDate;
	}

	public void setHopeDate(String hopeDate) {
		this.hopeDate = hopeDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserAccount getSubmitUser() {
		return submitUser;
	}

	public void setSubmitUser(UserAccount submitUser) {
		this.submitUser = submitUser;
	}


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public UserAccount getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(UserAccount auditUser) {
		this.auditUser = auditUser;
	}

	public byte getAuditState() {
		return auditState;
	}

	public void setAuditState(byte auditState) {
		this.auditState = auditState;
	}

	public byte getUpdateState() {
		return updateState;
	}

	public void setUpdateState(byte updateState) {
		this.updateState = updateState;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuditReason() {
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
		this.auditReason = auditReason;
	}
}
