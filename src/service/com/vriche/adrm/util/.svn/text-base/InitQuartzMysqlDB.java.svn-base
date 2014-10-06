package com.vriche.adrm.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hsqldb.persist.HsqlProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.ibatis.common.resources.Resources;
import com.vriche.adrm.Constants;

public class InitQuartzMysqlDB implements InitializingBean, DisposableBean {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private Properties serverProperties;
	
	private DataSource dataSource;
	
	public void afterPropertiesSet() throws Exception {
		

		 
		 HsqlProperties configProps = new HsqlProperties(serverProperties);
		 String dbName = configProps.getProperty("server.dbname");
		 String usrname = configProps.getProperty("server.usrname");
		 String password = configProps.getProperty("server.password");
		 String url = configProps.getProperty("server.url");
		 String scriptFile = configProps.getProperty("server.scriptFile");
		 
//		 setDBbackupPropertiesFile(configProps);
		 
		 
		 
		 
	
//		 url = url + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			  logger.info("initQuartzMysqlDB>>>>>>>>>>>>>url>>>>>>>>>>>>>"+url);
		    Connection conQuartz=(Connection) DriverManager.getConnection(url,usrname,password); 
		    conQuartz.close();
		    
		    logger.info("initQuartzMysqlDB>>>>>>>>>>>>>quartz  found!");
		    
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
			   try {
				   
                    String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
                    Connection conDefault =dataSource.getConnection();
                    Statement stat=conDefault.createStatement(); 
                    stat.execute(sql);

				    String fileStr = Constants.FILE_PATH_SQL_SCRIPT + scriptFile;
				    String sqlFile = Resources.getResourceAsFile(fileStr).getAbsolutePath();
				    logger.info("initQuartzMysqlDB>>>>>>>>>>>>>load quartz db...........");
					new  DBLoader("mysql",url,"",sqlFile,usrname,password);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   
			   
//			   e.printStackTrace();

		   }catch (ClassNotFoundException e) { 
			   
//			   e.printStackTrace(); 
		   } 


	}
	
	
	private void setDBbackupPropertiesFile(HsqlProperties configProps){
		Properties ps = HandlePropertiesUtil.getDBBackupProperties();
		 String url = configProps.getProperty("server.url");
		 String db_database = configProps.getProperty("server.db");
		 String db_user = configProps.getProperty("server.usrname");
		 String db_pass = configProps.getProperty("server.password");
		 String db_host  =  StringUtil.getMatchContent2(url,"//","/");
		 
		
		 
		  ps.setProperty("db_host",db_host);
		  ps.setProperty("db_database",db_database);
//		  ps.setProperty("db_path",db_path);
		  ps.setProperty("db_user",db_user);
		  ps.setProperty("db_pass",db_pass);
		  
		  logger.info("initQuartzMysqlDB>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>db_host..........." +db_host);
		  HandlePropertiesUtil.savDatabaseBackupProperty(ps);
	}
	
	

	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setServerProperties(Properties serverProperties) {
		this.serverProperties = serverProperties;
	}
}
