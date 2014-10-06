package com.vriche.adrm.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vriche.adrm.Constants;

public class SysUtil {
	
	private static final Log log = LogFactory.getLog(DateUtil.class);
	
    public  String getGlobalParams(String loginName){
    	
        loginName = StringUtil.getNullValue(loginName,"");
        
        if("".equals("")){
       	 	loginName = UserUtil.getCurrentPrincipalUser();
        }
     	String s = String.valueOf(Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAMS));
     	
     	

     	
     	s = StringUtil.oldReplace(s,"adrm_logined_user",loginName);
     	
     	
     	
    	 log.info(">>>>>>>>>>>>>getGlobalParams>>>>>>>>>>>>>>>>" +s);

    	 return s; 
    }
    
     /** 
          * 用来获得到WEB-INF的路径 
         */  
    public static String getAddress(){  
    	Class theClass = DateUtil.class;  
    	  java.net.URL u = theClass.getResource("");  
//    	str会得到这个函数所在类的路径  
    	  String str = u.toString();  
//    	截去一些前面6个无用的字符  
    	  str=str.substring(6,str.length());  
//    	将%20换成空格（如果文件夹的名称带有空格的话，会在取得的字符串上变成%20）  
    	  str=str.replaceAll("%20", " ");  
//    	查找“WEB-INF”在该字符串的位置  
    	  int num = str.indexOf("WEB-INF");  
//    	截取即可  
    	  str=str.substring(0, num+"WEB-INF".length());  
    	  return str;  	
    }
    	

}
