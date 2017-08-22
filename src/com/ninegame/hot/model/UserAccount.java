package com.ninegame.hot.model;

public class UserAccount {

	private int id;
	
	private String userName;
	
	private String name;
	
	private String regTime;
	
	private String password;
	
	private byte identifyLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getIdentifyLevel() {
		return identifyLevel;
	}

	public void setIdentifyLevel(byte identifyLevel) {
		this.identifyLevel = identifyLevel;
	}			
}
