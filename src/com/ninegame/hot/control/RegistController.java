package com.ninegame.hot.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninegame.hot.global.GlobalConst;
import com.ninegame.hot.iservice.UserAccountService;
import com.ninegame.hot.model.UserAccount;
import com.ninegame.hot.util.TimeUtil;

@Controller
public class RegistController {

	@Resource
	private UserAccountService userAccountServiceBean;
	
	@RequestMapping("/registPage")
	public String viewRegist(){
		return "regist";
	}
	
	@RequestMapping("/registPost")
	public String postRegist(String name,String password,String confirmPs,String userName,byte identifyLevel,
			HttpServletRequest request){
		if(userName== null || userName.trim().equals("")){
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册失败，参数错误!");
			return "error";
		}
		if(!password.equals(confirmPs)){
			//两次密码不一致
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册失败，两次密码不一致!");
			return "error";
		}
		try{
			if(userAccountServiceBean.existName(name) > 0){
				request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册失败，姓名已存在!");
				return "error";
			}
			if(userAccountServiceBean.existUserName(userName) > 0){
				request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册失败，用户名已注册!");
				return "error";
			}
		}catch(Exception e){
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册失败，数据库报错!");
			return "error";
		}
		UserAccount userAccount = new UserAccount();
		userAccount.setIdentifyLevel(identifyLevel);
		userAccount.setName(name);
		userAccount.setPassword(password);
		userAccount.setRegTime(TimeUtil.formatDate(TimeUtil.long2Date(TimeUtil.getNowTime())));
		userAccount.setUserName(userName);
		try {
			userAccountServiceBean.addOrUpdate(userAccount);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册失败，数据库报错!");
			return "error";
		}
		request.getSession().setAttribute(GlobalConst.SESSION_KEY_USER, userAccount);
		request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "注册成功！");
		return "error";
	}
}
