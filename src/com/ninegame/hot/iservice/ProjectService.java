package com.ninegame.hot.iservice;

import java.util.List;
import java.util.Map;

import com.ninegame.hot.model.Project;

public interface ProjectService {

	public void addOrUpdate(Project pro) throws Exception;
	
	public void delete(int proId) throws Exception;
	
	public List<Project> query(Map<String,Object> paramMap) throws Exception;
	
	public int existProject(String proName) throws Exception;
}
