package com.ninegame.hot.mvc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

public class EncodingDispatcherServlet extends DispatcherServlet{  
	private static final long serialVersionUID = 1L;
	protected String encoding;  
      
    @Override  
    protected void doService(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
        request.setCharacterEncoding(encoding);  
        super.doService(request, response);  
    }  
  
    @Override  
    public void init(ServletConfig config) throws ServletException {  
        encoding = config.getInitParameter("encoding");  
        super.init(config);  
    }  
  
}  