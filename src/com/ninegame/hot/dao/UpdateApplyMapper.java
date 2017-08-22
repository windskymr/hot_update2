package com.ninegame.hot.dao;

import java.util.List;
import java.util.Map;

import com.ninegame.hot.model.UpdateApply;

public interface UpdateApplyMapper extends Pagable{

	public void addOrUpdate(UpdateApply apply);
	
	public void delete(int applyId);
	
	public List<UpdateApply> query(Map<String,Object> paramMap);
	
	public void auditApply(UpdateApply apply);
	
	/**
	 * 设置申请已更新
	 * @param apply
	 */
	public void doUpdateApply(UpdateApply apply);
	
	public UpdateApply getStateApply(int id);
}
