package com.ninegame.hot.dao;

import java.util.List;
import java.util.Map;

import com.ninegame.hot.model.Project;

public interface ProjectMapper {

	
	public void addOrUpdate(Project pro);
	
	public void delete(int proId);
	
	public List<Project> query(Map<String,Object> paramMap);
	
	public int existProject(String proName);
	
	public Project getProject(int projectId);
}
