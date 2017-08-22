package com.ninegame.hot.iservice.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ninegame.hot.dao.ProjectMapper;
import com.ninegame.hot.iservice.ProjectService;
import com.ninegame.hot.model.Project;
import com.ninegame.hot.util.MyBatisUtil;

public class ProjectServiceBean implements ProjectService{

	@Override
	public void addOrUpdate(Project pro) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			ProjectMapper mapper = session.getMapper(ProjectMapper.class);
			mapper.addOrUpdate(pro);
			session.commit();			
		}
		finally{
			session.close();
		}
	}

	@Override
	public void delete(int proId) throws Exception {
		
	}

	@Override
	public List<Project> query(Map<String, Object> paramMap) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			ProjectMapper mapper = session.getMapper(ProjectMapper.class);
			return mapper.query(paramMap);
		}
		finally{
			session.close();
		}
	}

	@Override
	public int existProject(String proName) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			ProjectMapper mapper = session.getMapper(ProjectMapper.class);
			return mapper.existProject(proName);
		}
		finally{
			session.close();
		}
	}

}
