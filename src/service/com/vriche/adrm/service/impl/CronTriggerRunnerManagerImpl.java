
/*
 * Created on Sep 21, 2006
 * 
 * This class is to run a scheduler with CronTrigger
 */
package com.vriche.adrm.service.impl;

import java.util.Properties;

import com.vriche.adrm.Constants;
import com.vriche.adrm.service.CronTriggerRunnerManager;
import com.vriche.adrm.util.HandlePropertiesUtil;

/**
 */
public class CronTriggerRunnerManagerImpl implements CronTriggerRunnerManager {
 
	public void setParameter(String startup,String ldap,String casLogoutUrl,String casLoginUrl,String casServiceUrl,String casServerName,String casValidateUrl){
        
		Properties pt=new Properties();
		HandlePropertiesUtil.load("cas.properties");

		pt.setProperty(Constants.CAS_AUTH_ENABLED,startup);
		pt.setProperty(Constants.CAS_IMPORT_FROM_LDAP,ldap);
		pt.setProperty(Constants.CAS_LOGOUT_URL,casLogoutUrl);
		pt.setProperty(Constants.CAS_LOGIN_URL,casLoginUrl);
		
		pt.setProperty(Constants.CAS_SERVICE_URL,casServiceUrl);
		pt.setProperty(Constants.CAS_SERVER_NAME,casServerName);
		pt.setProperty(Constants.CAS_VALIDATE_URL,casValidateUrl);
//		System.out.println("casLoginUrl<<<<<<<<<<222222222<<<<<<<<<<<<"+pt.getProperty(Constants.CAS_LOGIN_URL));
		HandlePropertiesUtil.save("cas.properties",pt);
		
	}
	
	public String[] getParameter(){
        
		Properties pt = HandlePropertiesUtil.load("cas.properties");
		
		String[] casParam = new String[7];
		casParam[0] = pt.getProperty(Constants.CAS_AUTH_ENABLED);
		casParam[1] = pt.getProperty(Constants.CAS_IMPORT_FROM_LDAP);
		casParam[2] = pt.getProperty(Constants.CAS_LOGIN_URL);
		casParam[3] = pt.getProperty(Constants.CAS_LOGOUT_URL);
//		System.out.println("CAS_AUTH_ENABLED<<<<<<<<<<11111111111<<<<<<<<<<<<"+casParam[0] );
//		System.out.println("CAS_IMPORT_FROM_LDAP<<<<<<<<<<222222222<<<<<<<<<<<<"+casParam[1]);
		casParam[4] = pt.getProperty(Constants.CAS_SERVER_NAME);
		casParam[5] = pt.getProperty(Constants.CAS_SERVICE_URL);
		casParam[6] = pt.getProperty(Constants.CAS_VALIDATE_URL);
		
		return casParam;
		
	}
	
}
