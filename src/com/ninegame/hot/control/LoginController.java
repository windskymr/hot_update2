package com.ninegame.hot.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninegame.hot.global.GlobalConst;
import com.ninegame.hot.iservice.UserAccountService;
import com.ninegame.hot.model.UserAccount;

@Controller
public class LoginController {

	@Resource
	private UserAccountService userAccountServiceBean;
	
	@RequestMapping("/loginPage")
	public String viewLogin(){
		return "login";
	}
	
	@RequestMapping("/main")
	public String viewMain(){
		return "main";
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpServletRequest request){
		request.getSession().setAttribute(GlobalConst.SESSION_KEY_USER, null);
		return "redirect:/main";
	}
	
	@RequestMapping("/loginPost")
	public String postLogin(String userName,String password, HttpServletRequest request){
		UserAccount user = null;
		try{
			user = userAccountServiceBean.getUser(userName, password);
		}catch(Exception e){
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "System error!");
			return "error";
		}
		if(user == null){
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "用户名或密码错误!");
			return "error";
		}
		request.getSession().setAttribute(GlobalConst.SESSION_KEY_USER, user);
		request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "登陆成功!");
		return "error";
	}
}
