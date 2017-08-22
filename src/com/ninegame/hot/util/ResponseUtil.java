package com.ninegame.hot.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public static void writeString(HttpServletResponse response, String str, String chaset) throws IOException{
		response.setCharacterEncoding(chaset);
		PrintWriter writer = response.getWriter();
		try{
			writer.write(str);
		}catch(Exception e){}
		finally{
			try{
				writer.close();
			}catch(Exception e){}
		}
	}
}
