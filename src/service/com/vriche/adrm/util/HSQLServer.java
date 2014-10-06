package com.vriche.adrm.util;

import org.hsqldb.Server;
import org.hsqldb.ServerConfiguration;
import org.hsqldb.ServerConstants;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.lib.FileUtil;  

public class HSQLServer extends Server {
	
	public static void start(String[] args) {  
		 
	       String propsPath = FileUtil.canonicalOrAbsolutePath("server");  
	       HsqlProperties fileProps = ServerConfiguration.getPropertiesFromFile(propsPath);  
	       HsqlProperties props = fileProps == null ? new HsqlProperties(): fileProps;  
	       HsqlProperties stringProps = HsqlProperties.argArrayToProps(args, ServerConstants.SC_KEY_PREFIX);  
	 
	       if (stringProps != null) {  
	           if (stringProps.getErrorKeys().length != 0) {  
	               printHelp("server.help");  
	               return;  
	           }  
	           props.addProperties(stringProps);  
	       }  
	       ServerConfiguration.translateDefaultDatabaseProperty(props);  
	 
	       ServerConfiguration.translateDefaultNoSystemExitProperty(props);  
	 
	       Server server = new Server();  
	 
	       server.setProperties(props);  
	 
	       server.start();  
	   }  
}
