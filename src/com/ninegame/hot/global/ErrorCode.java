package com.ninegame.hot.global;

public enum ErrorCode {
	
	APPLY_NOT_EXIST(1001, "申请不存在"),
	APPLY_STATE_ERROR(1002, "申请状态错误"),
	
	SUCESS(1000,"");
	
	private final int code;
	private final String desc;;
	
	private ErrorCode(int code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public int getErrorCode(){
		return code;
	}
	
	public String getErrorDesc(){
		return desc;
	}
}
