package com.vriche.adrm.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hsqldb.Server;
import org.hsqldb.ServerConfiguration;
import org.hsqldb.ServerConstants;
import org.hsqldb.persist.HsqlProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.ibatis.common.resources.Resources;
import com.vriche.adrm.Constants;

/**
 * Bean that will start an instance of an HSQLDB database. In contrast to the in memory variant you
 * can connect via a normal JDBC client to this database.
 * <p>
 * A possible configuration might look like this;
 * 
 * <pre>
	<bean id="database" class="com.vriche.adrm.util.HSQLServerBean" lazy-init="false">
		<property name="serverProperties">
			<props>
				<prop key="server.port">9000</prop>
				<prop key="server.database.0">mem:test</prop>
				<prop key="server.dbname.0">test</prop>
			</props>
		</property>
	</bean>
 * </pre>
 * 
 * The connection URL would then be: jdbc:hsqldb:hsql://localhost:9000/test
 * 
 * @see org.hsqldb.Server
 * 
 * @author Koen Serneels
 */
public class HsqldbServerBean implements InitializingBean, DisposableBean {

	private final Logger logger = Logger.getLogger(HsqldbServerBean.class);

	/** Properties used to customize instance */
	private Properties serverProperties;
	/** The actual server instance */
	private Server server;
	/** DataSource used for shutdown. */
	private DataSource dataSource;

	public void afterPropertiesSet() throws Exception {

		HsqlProperties configProps = new HsqlProperties(serverProperties);
		configProps.setProperty(ServerConfiguration.SC_DEFAULT_ADDRESS, "jdbc:hsqldb:.:test");
		configProps.setProperty(ServerConfiguration.SC_DEFAULT_DATABASE, "jdbc:hsqldb:.:test");
		
		String servletContexRoot = (String)Constants.APPLACTION_MAP.get(Constants.FILE_PATH_SERVELT_CONTEXT_ROOT);
//		Files.checkFile(servletContexRoot,"quartz");
		String dbPath =  configProps.getProperty("server.database.0");
		String port = configProps.getProperty("server.port");
		String dbName = configProps.getProperty("server.dbname.0");
		String scriptFile = Constants.FILE_PATH_SQL_SCRIPT + configProps.getProperty("server.scriptFile.0");

		configProps.setProperty("server.database.0",servletContexRoot + dbPath);

		ServerConfiguration.translateDefaultDatabaseProperty(configProps);

		server = new Server();
		server.setRestartOnShutdown(false);
		server.setNoSystemExit(true);
		server.setProperties(configProps);

		logger.info("HSQL Server startup sequence initiated");
		
		if (portAvailable()) {
			server.start();
			logger.info("HSQL Server listening on port: " + server.getPort());
			
			loadData(servletContexRoot, dbName,dbPath, port, scriptFile);
			
		
			
		} else {
			logger.warn("HSQLDB Server was NOT started, the port " + server.getPort() + " was allready in use");
		}

	}
	
	
	
	private void loadData(String servletContexRoot,String dbName,String dbPath,String port,String sqlFile){
//		File dbScriptFile = new File(servletContexRoot + dbName + ".script");   
		
		

		
//		if (!dbScriptFile.exists()){//判断数据文件是否存在   
//			File file;
			try {
				File file = Resources.getResourceAsFile(sqlFile);
	
				 String url = "hsql://localhost:"+port+"/"+dbName;
				
				 String scriptFile =  file.getAbsolutePath();
			     String TOKEN ="webapps";
			     int pos = scriptFile.indexOf(TOKEN);
			     scriptFile = scriptFile.substring(0,pos+TOKEN.length());
			     scriptFile = scriptFile +  dbPath + ".script";  
			     
			     File dbScriptFile = new File(scriptFile);
			     if (!dbScriptFile.exists()){
						new  DBLoader("hypersonic",url,scriptFile,file.getAbsolutePath(),"sa","");
			     }

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
	
//		}
		
	}

	private boolean portAvailable() {
		Socket socket = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), server.getPort()), 1000);
		} catch (UnknownHostException e) {
			return true;
		} catch (IOException e) {
			return true;
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// Do nothing
				}
			}
		}
		return false;
	}

	public void destroy() {

		logger.info("HSQL Server shutdown sequence initiated");
		if (dataSource != null) {
			Connection connection = null;
			try {
				connection = dataSource.getConnection();
				connection.createStatement().execute("SHUTDOWN");
			} catch (SQLException e) {
				logger.error("HSQL Server shutdown failed: " + e.getMessage());
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception ignore) {
					// IGNORE
				}
			}
		} else {
			logger.warn("HsqlServerBean needs a dataSource property set to shutdown database safely.");
		}
		server.signalCloseAllServerConnections();
		int status = server.stop();
		long timeout = System.currentTimeMillis() + 5000;
		while (status != ServerConstants.SERVER_STATE_SHUTDOWN && System.currentTimeMillis() < timeout) {
			try {
				Thread.sleep(100);
				status = server.getState();
			} catch (InterruptedException e) {
				logger.error("Error while shutting down HSQL Server: " + e.getMessage());
				break;
			}
		}
		if (status != ServerConstants.SERVER_STATE_SHUTDOWN) {
			logger.warn("HSQL Server failed to shutdown properly.");
		} else {
			logger.info("HSQL Server shutdown completed");
		}
		server = null;
	}

	public void setServerProperties(Properties serverProperties) {
		this.serverProperties = serverProperties;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
