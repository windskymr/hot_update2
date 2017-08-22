package com.ninegame.hot.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ninegame.hot.dao.Pagable;
import com.ninegame.hot.dao.UpdateApplyMapper;
import com.ninegame.hot.global.ErrorCode;
import com.ninegame.hot.global.GlobalConst;
import com.ninegame.hot.global.WordConst;
import com.ninegame.hot.iservice.ProjectService;
import com.ninegame.hot.iservice.UpdateApplyService;
import com.ninegame.hot.model.Project;
import com.ninegame.hot.model.UpdateApply;
import com.ninegame.hot.model.UserAccount;
import com.ninegame.hot.page.PagableService;
import com.ninegame.hot.page.PageObject;
import com.ninegame.hot.util.ResponseUtil;
import com.ninegame.hot.util.TimeUtil;

@Controller
@RequestMapping("/login")
public class ApplyController {

	private final static String CUR_PATH = "/login";
	@Resource
	private UpdateApplyService updateApplyServiceBean;
	
	@Resource
	private ProjectService projectServiceBean;
	
	@RequestMapping("queryApply")
	public String viewApplyList(String jmpUrl, String pagePerSize,String pageCurNum,
			String submitTrueName,String auditTrueName,
			String auditState,String updateState,String proId,String curVer,
			String destVer,String clientCharger,
			String serverCharger,String wcCharger,String testCharger,
			String uiCharger,String masterCharger,
			String fromHopeDate,String toHopeDate,
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException{
		String pageSize = pagePerSize;
		String pageNum = pageCurNum;
		int ipageSize = 0;
		int ipageNum = 0;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		if(curVer != null && !"".equals(curVer)){
			paramMap.put(WordConst.CUR_VER, curVer);
		}
		if(destVer != null && !"".equals(destVer)){
			paramMap.put(WordConst.DEST_VER, destVer);
		}
		if(clientCharger != null && !"".equals(clientCharger)){
			clientCharger = new String(clientCharger.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.CLIENT_CHARGER, clientCharger);
		}
		if(serverCharger != null && !"".equals(serverCharger)){
			serverCharger = new String(serverCharger.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.SERVER_CHARGER, serverCharger);
		}
		if(wcCharger != null && !"".equals(wcCharger)){
			wcCharger = new String(wcCharger.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.WC_CHARGER, wcCharger);
		}
		if(testCharger != null && !"".equals(testCharger)){
			testCharger = new String(testCharger.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.TEST_CHARGER, testCharger);
		}
		if(uiCharger != null && !"".equals(uiCharger)){
			uiCharger = new String(uiCharger.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.UI_CHARGER, uiCharger);
		}
		if(masterCharger != null && !"".equals(masterCharger)){
			masterCharger = new String(masterCharger.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.MASTER_CHARGER, masterCharger);
		}
		if(pageSize != null && !pageSize.trim().equals("")){
			ipageSize = Integer.parseInt(pageSize);
			paramMap.put(WordConst.PAGE_SIZE, ipageSize);
		}
		if(pageNum != null && !pageNum.trim().equals("")){
			ipageNum = Integer.parseInt(pageNum);
			paramMap.put(WordConst.PAGE_NUM, ipageNum);
		}
		if(submitTrueName != null && !submitTrueName.trim().equals("")){
			submitTrueName = submitTrueName.trim();
			submitTrueName = new String(submitTrueName.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.SUBMIT_TRUE_NAME, submitTrueName);
		}
		if(auditTrueName != null && !auditTrueName.trim().equals("")){
			auditTrueName = auditTrueName.trim();
			auditTrueName = new String(auditTrueName.getBytes(GlobalConst.PAGE_FROM_CHASET), GlobalConst.UTF8_CHASET);
			paramMap.put(WordConst.AUDIT_TRUE_NAME, auditTrueName);
		}
		if(auditState != null && !auditState.trim().equals("")){
			paramMap.put(WordConst.AUDIT_STATE, Byte.parseByte(auditState));
		}
		if(updateState != null && !updateState.trim().equals("")){
			paramMap.put(WordConst.UPDATE_STATE, Byte.parseByte(updateState));
		}
		if(fromHopeDate != null && !fromHopeDate.trim().equals("")){
			paramMap.put(WordConst.FROM_HOPE_DATE, fromHopeDate);
		}
		if(toHopeDate != null && !toHopeDate.trim().equals("")){
			paramMap.put(WordConst.TO_HOPE_DATE, toHopeDate);
		}
		if(proId != null && !proId.trim().equals("")){
			paramMap.put(WordConst.PRO_ID, Integer.parseInt(proId));
		}
		paramMap.put(WordConst.PAGE_FROM, ipageSize * (ipageNum - 1) + 0);
		try {
			@SuppressWarnings("unchecked")
			PageObject pageObject = PagableService.queryPageRecords(paramMap, (Class<Pagable>)(Class<?>)UpdateApplyMapper.class);
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_PAGEOBJ, pageObject);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "查询失败!");
			return "redirect:/error.jsp";
		}
		if(jmpUrl == null){
			try{
				List<Project> proList = projectServiceBean.query(new HashMap<String,Object>());
				request.getSession().setAttribute(GlobalConst.SESSION_KEY_PROLIST, proList);
			}catch(Exception e){}
			return CUR_PATH + "/" + "applylistMain";
		}
		else{
			return CUR_PATH + "/" + jmpUrl;
		}
	}
	
	@RequestMapping("/applyadd")
	public String viewApplyAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Project> proList = projectServiceBean.query(new HashMap<String,Object>());
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_PROLIST, proList);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "查询失败!");
			return "redirect:/error.jsp";
		}
		return CUR_PATH + "/applyadd";
	}
	
	@RequestMapping("/applyaudit")
	public void auditApply(byte auditState, String reason,
			int applyId,
			HttpServletRequest request, HttpServletResponse response){
		UpdateApply apply = new UpdateApply();
		apply.setId(applyId);
		apply.setAuditReason(reason);
		apply.setAuditState(auditState);
		apply.setAuditTime(TimeUtil.formatDate(TimeUtil.long2Date(TimeUtil.getNowTime())));
		apply.setAuditUser((UserAccount)request.getSession().getAttribute(GlobalConst.SESSION_KEY_USER));
		JSONObject jo = new JSONObject();
		try {
			ErrorCode err = updateApplyServiceBean.auditApply(apply);
			if(err == ErrorCode.SUCESS){
				jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_SUC);
			}
			else{
				jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
				jo.put(WordConst.ERROR_INFO, "操作失败: " + err.getErrorDesc());
			}
		} catch (Exception e) {
			jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
			jo.put(WordConst.ERROR_INFO, "操作失败: " + e.getLocalizedMessage());
		}
		String retStr = jo.toJSONString();
		try {
			ResponseUtil.writeString(response, retStr, GlobalConst.UTF8_CHASET);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/applyupdate")
	public void updateApply(int applyId,
			HttpServletRequest request, HttpServletResponse response){
		JSONObject jo = new JSONObject();
		PageObject pageObj = (PageObject)request.getSession().getAttribute(GlobalConst.SESSION_KEY_PAGEOBJ);
		if(pageObj == null){
			jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
			jo.put(WordConst.ERROR_INFO, "Session已失效，请刷新后重试!");
		}
		else{
			UpdateApply target = getUpdateApply(pageObj, applyId);
			if(target == null){
				jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
				jo.put(WordConst.ERROR_INFO, "Session已失效，请刷新后重试!");
			}
			else{
				UserAccount opUser = (UserAccount)request.getSession().getAttribute(GlobalConst.SESSION_KEY_USER);
				if(!target.getSubmitUser().getUserName().equals(opUser.getUserName())){
					jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
					jo.put(WordConst.ERROR_INFO, "您不是申请提交者，不能进行更新操作!");
				}
				else{
					UpdateApply apply = new UpdateApply();
					apply.setId(applyId);
					apply.setUpdateTime(TimeUtil.formatDate(TimeUtil.long2Date(TimeUtil.getNowTime())));
					try {
						ErrorCode err = updateApplyServiceBean.doUpdateApply(apply);
						if(err == ErrorCode.SUCESS){
							jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_SUC);
						}
						else{
							jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
							jo.put(WordConst.ERROR_INFO, "操作失败: " + err.getErrorDesc());
						}
					} catch (Exception e) {
						jo.put(WordConst.RESULT, GlobalConst.OP_RESULT_FAILD);
						jo.put(WordConst.ERROR_INFO, "操作失败: " + e.getLocalizedMessage());
					}
				}
			}
		}
		String retStr = jo.toJSONString();
		try {
			ResponseUtil.writeString(response, retStr, GlobalConst.UTF8_CHASET);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/applyaddPost")
	public String addApply(String applyDesc,String proId,String curVer,String destVer,
			String clientCharger,String serverCharger,String wcCharger,
			String testCharger,String uiCharger,String masterCharger,
			String hopeDate,HttpServletRequest request,HttpServletResponse response
			) throws IOException{
		int iProId = 0;
		try{
			iProId = Integer.parseInt(proId);
		}catch(Exception e){
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "参数错误!");
			return "redirect:/error.jsp";
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Project> proList = (List)request.getSession().getAttribute(GlobalConst.SESSION_KEY_PROLIST);
		if(proList == null){
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "session已失效, 请把原页面刷新后重试!");
			return "redirect:/error.jsp";
		}
		Project project = null;
		for(Project pro : proList){
			if(pro.getId() == iProId){
				project = pro;
				break;
			}
		}
		if(project == null){
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "session已失效, 请把原页面刷新后重试!");
			return "redirect:/error.jsp";
		}
		UserAccount accout = (UserAccount)request.getSession().getAttribute(GlobalConst.SESSION_KEY_USER);
		UpdateApply apply = new UpdateApply();
		apply.setProject(project);
		apply.setRemark(applyDesc);
		apply.setSubmitTime(TimeUtil.formatDate(TimeUtil.long2Date(TimeUtil.getNowTime())));
		apply.setSubmitUser(accout);
		apply.setClientCharger(clientCharger);
		apply.setCurVer(curVer);
		apply.setDestVer(destVer);
		apply.setMasterCharger(masterCharger);
		apply.setServerCharger(serverCharger);
		apply.setTestCharger(testCharger);
		apply.setUiCharger(uiCharger);
		apply.setWcCharger(wcCharger);
		apply.setHopeDate(hopeDate);
		try {
			updateApplyServiceBean.addOrUpdate(apply);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "添加热更新申请失败!");
			return "redirect:/error.jsp";
		}
		request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "添加热更新申请成功!");
		return "redirect:/error.jsp";
	}

	private UpdateApply getUpdateApply(PageObject po, int id){
		List<Object> list = po.getDataList();
		if(list == null){
			return null;
		}
		for(Object o : list){
			if(!(o instanceof UpdateApply)){
				return null;
			}
			UpdateApply ua = (UpdateApply)o;
			if(ua.getId() == id){
				return ua;
			}
		}
		return null;
	}
}
