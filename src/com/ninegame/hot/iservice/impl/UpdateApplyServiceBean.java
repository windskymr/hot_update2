package com.ninegame.hot.iservice.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ninegame.hot.dao.UpdateApplyMapper;
import com.ninegame.hot.global.ErrorCode;
import com.ninegame.hot.global.GlobalConst;
import com.ninegame.hot.iservice.UpdateApplyService;
import com.ninegame.hot.model.UpdateApply;
import com.ninegame.hot.util.MyBatisUtil;

public class UpdateApplyServiceBean implements UpdateApplyService{

	@Override
	public void addOrUpdate(UpdateApply apply) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UpdateApplyMapper mapper = session.getMapper(UpdateApplyMapper.class);
			mapper.addOrUpdate(apply);
			session.commit();			
		}
		finally{
			session.close();
		}
	}

	@Override
	public void delete(int applyId) throws Exception {
		
	}

	@Override
	public List<UpdateApply> query(Map<String, Object> paramMap)
			throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UpdateApplyMapper mapper = session.getMapper(UpdateApplyMapper.class);
			return mapper.query(paramMap);
		}
		finally{
			session.close();
		}
	}

	@Override
	public synchronized ErrorCode auditApply(UpdateApply apply) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UpdateApplyMapper mapper = session.getMapper(UpdateApplyMapper.class);
			UpdateApply stateApply = mapper.getStateApply(apply.getId());
			if(stateApply == null){
				return ErrorCode.APPLY_NOT_EXIST;
			}
			if(stateApply.getAuditState() != GlobalConst.AUDIT_STATE_NOT_YET){
				//未审核
				return ErrorCode.APPLY_STATE_ERROR;
			}
			mapper.auditApply(apply);
			session.commit();
			return ErrorCode.SUCESS;
		}
		finally{
			session.close();
		}
	}

	@Override
	public synchronized ErrorCode doUpdateApply(UpdateApply apply) throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		try{
			UpdateApplyMapper mapper = session.getMapper(UpdateApplyMapper.class);
			UpdateApply stateApply = mapper.getStateApply(apply.getId());
			if(stateApply == null){
				return ErrorCode.APPLY_NOT_EXIST;
			}
			if(stateApply.getAuditState() != GlobalConst.AUDIT_STATE_YES){
				return ErrorCode.APPLY_STATE_ERROR;
			}
			if(stateApply.getUpdateState() != GlobalConst.UPDATE_STATE_NOT_YET){
				return ErrorCode.APPLY_STATE_ERROR;
			}
			mapper.doUpdateApply(apply);
			session.commit();	
			return ErrorCode.SUCESS;
		}
		finally{
			session.close();
		}
	}

}
