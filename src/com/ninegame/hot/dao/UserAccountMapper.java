package com.ninegame.hot.dao;

import com.ninegame.hot.model.UserAccount;

public interface UserAccountMapper {

	public void addOrUpdate(UserAccount userAccount);
	
	public int existUserName(String userName);
	
	public int existName(String name);
	
	public UserAccount getUser(String userName, String password);
	
	public UserAccount getUserByUserName(String userName);
	
	public void delete(int userId);
}
