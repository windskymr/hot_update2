package com.ninegame.hot.control;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninegame.hot.global.GlobalConst;
import com.ninegame.hot.iservice.ProjectService;
import com.ninegame.hot.model.Project;
import com.ninegame.hot.model.UserAccount;
import com.ninegame.hot.util.TimeUtil;

@RequestMapping("/login")
@Controller
public class ProjectController {

	@Resource
	private ProjectService projectServiceBean;
	
	@RequestMapping("/proadd")
	public String viewAddProject(){
		return "/login/procreate";
	}
	
	@RequestMapping("/prolist")
	public String viewProList(HttpServletRequest request){
		try {
			List<Project> prjectList = projectServiceBean.query(new HashMap<String,Object>());
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_PROLIST, prjectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/login/" + GlobalConst.PATH_PROLIST;
	}
	
	@RequestMapping("/proaddPost")
	public String addProject(String proDesc, String proName, HttpServletRequest request){
		try {
			int result = projectServiceBean.existProject(proName);
			if(result > 0){
				request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "创建项目失败，项目名称已存在!");
				return "redirect:/error.jsp";
			}
			Project pro = new Project();
			pro.setCreateTime(TimeUtil.formatDate(TimeUtil.long2Date(TimeUtil.getNowTime())));
			pro.setCreatorUser((UserAccount)request.getSession().getAttribute(GlobalConst.SESSION_KEY_USER));
			pro.setDescribe(proDesc);
			pro.setName(proName);
			projectServiceBean.addOrUpdate(pro);
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "创建项目成功!");
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(GlobalConst.SESSION_KEY_ERRORDESC, "创建项目失败!");
		}
		return "redirect:/error.jsp";
	}
}
