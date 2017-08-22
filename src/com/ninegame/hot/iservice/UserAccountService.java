package com.ninegame.hot.iservice;

import com.ninegame.hot.model.UserAccount;

public interface UserAccountService {
	/**
	 * 
	 * @param userAccount
	 * @throws Exception
	 */
	public void addOrUpdate(UserAccount userAccount) throws Exception;
	
	public int existUserName(String userName) throws Exception;
	
	public int existName(String name) throws Exception;
	
	public void delete(int userId) throws Exception;
	
	public UserAccount getUser(String userName, String password) throws Exception;
}
