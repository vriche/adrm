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
          * ������õ�WEB-INF��·�� 
         */  
    public static String getAddress(){  
    	Class theClass = DateUtil.class;  
    	  java.net.URL u = theClass.getResource("");  
//    	str��õ���������������·��  
    	  String str = u.toString();  
//    	��ȥһЩǰ��6�����õ��ַ�  
    	  str=str.substring(6,str.length());  
//    	��%20���ɿո�����ļ��е����ƴ��пո�Ļ�������ȡ�õ��ַ����ϱ��%20��  
    	  str=str.replaceAll("%20", " ");  
//    	���ҡ�WEB-INF���ڸ��ַ�����λ��  
    	  int num = str.indexOf("WEB-INF");  
//    	��ȡ����  
    	  str=str.substring(0, num+"WEB-INF".length());  
    	  return str;  	
    }
    	

}
