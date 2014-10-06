package com.vriche.adrm.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.vriche.adrm.service.SqlDumpManager;



public class SqlDumpManagerImpl implements Serializable, SqlDumpManager {


//	public static final SimpleDateFormat fullYearDateTime = new SimpleDateFormat("yyyyMMdd");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1246179304471331304L;
	private static final Logger logger = Logger.getLogger(SqlDumpManagerImpl.class); 

	public void testMethod3(){
		logger.info("testMethod3.......3");	
	}

//    public void start() throws JobExecutionException {
//
//    	Properties ps=HandlePropertiesUtil.load("qi.properties");
//    	
//        String host=ps.getProperty("host");
//        String user=ps.getProperty("user");
//        String pass=ps.getProperty("pass");
//        String database=ps.getProperty("database");
//        String path=ps.getProperty("path");
//        
//        String today = fullYearDateTime.format(new java.util.Date());     
//
////        String command = "mysqldump";
//        String command="mysqldump";
//        ClassLoader cl=Thread.currentThread().getContextClassLoader();
//        String url=""+cl.getResource("mysqldump");
//        
////        System.out.println("---command) url! ---" +url);
//        
//        if(url!=null) command=url.substring(6);
//        
//        String parameters = "--default-character-set=gbk -u"+user+" -p'"+pass+"' -h"+host+" -P3306 --opt "+database+" > "+ path +"/"+database+"_"+today+".sql";;
//        
////        try {
////			parameters = java.net.URLEncoder.encode(parameters,"UTF-8");
////		} catch (UnsupportedEncodingException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}  
//        
//            
//        //with this variable will be done the swithcing
//        String osName = System.getProperty("os.name");
//        String[] cmd=new String[3];
//        // specific for Windows
//        if (osName.startsWith("Windows")) {
////        	 if(url!=null) command=url.substring(6);
//            if (osName.equals("Windows 95")) { // windows 95 only
//            	cmd[0] = "command.com";
//            } else {
//            	cmd[0] = "cmd.exe";
//            }
//            cmd[1] =  "/C";
//            cmd[2] =  command + " " + parameters;
//        } else if (osName.equals("Linux")) {
//        	 if(url!=null) command=url.substring(5);
//        	cmd[0]="/bin/sh";
//        	cmd[1]="-c";
//        	cmd[2]=command + " " + parameters;
//        }
//        Runtime rt = Runtime.getRuntime();
//        // Executes the command
//        getLog().info("About to run " + cmd[0] + " " + cmd[1] + " " + (cmd.length>2 ? cmd[2] : "") + " ...");
//
//        try {
//			Process po=rt.exec(cmd);
//
//			byte[] error=new byte[1024];
//			po.getErrorStream().read(error);		
//			int resultCode=po.waitFor();
//			if(resultCode==0){
//				getLog().info(cmd[0] + " " + cmd[1] + " " + (cmd.length>2 ? cmd[2] : "") +" has already normal terminated.");
//			}else{
//				getLog().info(cmd[0] + " " + cmd[1] + " " + (cmd.length>2 ? cmd[2] : "") +" has already abnormal terminated.");
//				getLog().warn(" the reason for abnormal terminated is that "+new String(error));
//			}			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//    }  
//    protected  Logger getLog() {
//        return logger;
//    }
}
