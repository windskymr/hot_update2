package com.ninegame.hot.page;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ninegame.hot.dao.Pagable;
import com.ninegame.hot.global.WordConst;
import com.ninegame.hot.util.MyBatisUtil;

public class PagableService {
	
	public static PageObject queryPageRecords(Map<String, Object> param,Class<Pagable> clazz){
		PageObject pageObj = new PageObject(); 
		int pageNum = Integer.parseInt(param.get(WordConst.PAGE_NUM).toString());
		int pageSize = Integer.parseInt(param.get(WordConst.PAGE_SIZE).toString());
		pageObj.setPageCurNum(pageNum);
		pageObj.setPagePerSize(pageSize);
		SqlSession session = MyBatisUtil.openSession();
		try{
			Pagable mapper = session.getMapper(clazz);
			int totalSize = mapper.queryPageRecordSize(param);
			pageObj.setTotalSize(totalSize);
			int totalPages = (totalSize + pageSize -1) / pageSize;
			pageObj.setTotalPages(totalPages);
			pageObj.setDataList(mapper.queryPageRecords(param));
			pageObj.setCurDataSize(pageObj.getDataList().size());
		}finally{
			session.close();
		}
		return pageObj;
	}
	
	public static PageObject queryPageRecords(Map<String, Object> param,Class<Pagable> clazz, SqlSession session){
		PageObject pageObj = new PageObject(); 
		int pageNum = Integer.parseInt(param.get(WordConst.PAGE_NUM).toString());
		int pageSize = Integer.parseInt(param.get(WordConst.PAGE_SIZE).toString());
		pageObj.setPageCurNum(pageNum);
		pageObj.setPagePerSize(pageSize);
		try{
			Pagable mapper = session.getMapper(clazz);
			int totalSize = mapper.queryPageRecordSize(param);
			pageObj.setTotalSize(totalSize);
			int totalPages = (totalSize + pageSize -1) / pageSize;
			pageObj.setTotalPages(totalPages);
			pageObj.setDataList(mapper.queryPageRecords(param));
			pageObj.setCurDataSize(pageObj.getDataList().size());
		}finally{
		}
		return pageObj;
	}
}
