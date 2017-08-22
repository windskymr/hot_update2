package com.ninegame.hot.iservice;

import java.util.List;
import java.util.Map;

import com.ninegame.hot.global.ErrorCode;
import com.ninegame.hot.model.UpdateApply;

public interface UpdateApplyService {


	public void addOrUpdate(UpdateApply apply) throws Exception;
	
	public void delete(int applyId) throws Exception;
	
	public List<UpdateApply> query(Map<String,Object> paramMap) throws Exception;
	
	public ErrorCode auditApply(UpdateApply apply) throws Exception;
	
	/**
	 * 设置申请已更新
	 * @param apply
	 */
	public ErrorCode doUpdateApply(UpdateApply apply) throws Exception;
}
