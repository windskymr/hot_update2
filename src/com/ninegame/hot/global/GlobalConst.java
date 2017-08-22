package com.ninegame.hot.global;

public class GlobalConst {

	//用户
	public final static String SESSION_KEY_USER = "user";
	
	//错误描述
	public final static String SESSION_KEY_ERRORDESC = "error";
	
	//项目列表
	public final static String SESSION_KEY_PROLIST = "proList";
	
	//申请列表
	public final static String SESSION_KEY_APPLYLIST = "applyList";
	
	//分页数据
	public final static String SESSION_KEY_PAGEOBJ = "pageObj";
	
	
	public final static String PATH_PROLIST = "prolist";
	
	public final static String PATH_ERROR_PAGE = "error.jsp";
	
	public final static String PATH_APPLYLIST = "applylistMain.jsp";
	
	public final static String PAGE_FROM_CHASET = "ISO-8859-1";
	
	public final static String UTF8_CHASET = "UTF-8";
	
	public final static int OP_RESULT_SUC = 1;
	
	public final static int OP_RESULT_FAILD = 0;
	
	public final static byte UPDATE_STATE_NOT_YET = 0;
	
	public final static byte UPDATE_STATE_YES = 1;
	
	public final static byte AUDIT_STATE_NOT_YET = 0;
	
	public final static byte AUDIT_STATE_YES = 1;
	
	public final static byte AUDIT_STATE_FAILED = 2;
	
}
