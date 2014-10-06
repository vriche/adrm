package com.vriche.adrm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {
	
private static String path=HandlePropertiesUtil.class.getResource("/").getPath();
	
	public static Properties load(String url){
//		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		String realPath=path.substring(0,path.length()-8);
		
		Properties pt=new Properties();
		try {
			pt.load(new FileInputStream(realPath+url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pt;
	}

	public static void save(String url,Properties pt){
		OutputStream os = null;
//		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		String realPath=path.substring(0,path.length()-8);
		try {
			os = new FileOutputStream(realPath+url);
			pt.store(os,null);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			os=null;
			pt=null;
		}	
	}
}
