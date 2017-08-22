package com.ninegame.hot.iservice.impl;

import org.apache.ibatis.session.SqlSession;

import com.ninegame.hot.dao.UserAccountMapper;
import com.ninegame.hot.iservice.UserAccountService;
import com.ninegame.hot.model.UserAccount;
import com.ninegame.hot.util.MyBatisUtil;

public class UserAccountServiceBean implements UserAccountService{

	@Override
	public void addOrUpdate(UserAccount userAccount) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UserAccountMapper mapper = session.getMapper(UserAccountMapper.class);
			mapper.addOrUpdate(userAccount);
			session.commit();			
		}
		finally{
			session.close();
		}
	}

	@Override
	public int existUserName(String userName) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UserAccountMapper mapper = session.getMapper(UserAccountMapper.class);
			return mapper.existUserName(userName);
		}
		finally{
			session.close();
		}
	}

	@Override
	public int existName(String name) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UserAccountMapper mapper = session.getMapper(UserAccountMapper.class);
			return mapper.existName(name);
		}
		finally{
			session.close();
		}
	}

	@Override
	public void delete(int userId) throws Exception {
		
	}

	@Override
	public UserAccount getUser(String userName, String password)
			throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UserAccountMapper mapper = session.getMapper(UserAccountMapper.class);
			return mapper.getUser(userName, password);
		}
		finally{
			session.close();
		}
	}

}
