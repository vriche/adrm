package com.vriche.adrm.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.vriche.adrm.Constants;

public class SpringContext implements ApplicationContextAware {

	 protected static ApplicationContext context;
	    
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        context = applicationContext;
	    }

	    public static ApplicationContext getContext() {
	    	
//	    	if (context == null ){
//	    		String realpath = SysUtil.getAddress();
//	    		String resourceFile = realpath+  "/applicationContext-resources.xml";
//	    		String daoFile = realpath+  "/applicationContext-ibatis.xml";
//	    		String serviceFile = realpath+  "/applicationContext-service.xml";
//	    		String securityFile = realpath+  "/security.xml";	
//	    		String[] configs = new String[] {resourceFile,daoFile,serviceFile,securityFile};
//	    		context=new FileSystemXmlApplicationContext(configs);
//	    	}
	        return context;
	    }
	    
	    public static Object getBean(String name) {
	    	 return getContext().getBean(name);
	    }
	    
	    
	   

}
