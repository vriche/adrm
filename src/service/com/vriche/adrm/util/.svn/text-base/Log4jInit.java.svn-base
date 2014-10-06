package com.vriche.adrm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.vriche.adrm.Constants;


public class Log4jInit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -27465828107221480L;
	static Logger logger = Logger.getLogger(Log4jInit.class);
    public Log4jInit() {
    }

    public void init(ServletConfig config) throws ServletException {
        String prefix = config.getServletContext().getRealPath("/");
        String file = config.getInitParameter("log4j");
        String filePath = prefix + file;
  
        Properties props = new Properties();
        try {
            FileInputStream istream = new FileInputStream(filePath);
            props.load(istream);
            istream.close();
            prefix = prefix + "logs"+ Constants.FILE_SEP;
            String logFileName = props.getProperty(Constants.LOG4J_APPENDER_LOGFILE_PROPERTIES_KEY);
            String logFile = prefix + logFileName;//设置路径
            Files.checkFile(prefix,logFileName);
            System.out.println("logFile  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+logFile);
            props.setProperty(Constants.LOG4J_APPENDER_LOGFILE_PROPERTIES_KEY,logFile);
            PropertyConfigurator.configure(props);//装入log4j配置信息
        } catch (IOException e) {
            return;
        }
    }
}
