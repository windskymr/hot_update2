package com.ninegame.hot.dao;

import java.util.List;
import java.util.Map;

public interface Pagable {

	public int queryPageRecordSize(Map<String,Object> paramMap);
	
	public List<Object> queryPageRecords(Map<String,Object> paramMap);
	
	public List<Map<String,Object>> queryPageRecordsMap(Map<String,Object> paramMap);
}
