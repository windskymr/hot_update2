package com.ninegame.hot.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
    private static SqlSessionFactory factory;  
    
    private final static String CONFIG_PATH = "/config/mybatis.xml";
    
    public static SqlSessionFactory getSessionFactory(){  
    	
        if (factory == null){  
        	InputStream fis = null;
        	try{
        		fis = MyBatisUtil.class.getClassLoader().getResourceAsStream(CONFIG_PATH);
        	}catch(Exception e){
        		throw new RuntimeException(e);
        	}
            factory = new SqlSessionFactoryBuilder().build(fis);  
            try{
            	fis.close();
            }catch(Exception e){
            	e.printStackTrace();
            }
        }  
        return factory;  
    }  
      
    public static SqlSession openSession(){  
        return getSessionFactory().openSession();  
    }  
}
