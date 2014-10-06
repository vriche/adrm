package com.vriche.adrm.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;

import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.configuration.ConfigurationLoader;
import com.sshtools.j2ssh.sftp.SftpFile;
import com.vriche.adrm.Constants;
import com.vriche.adrm.service.SimpleService;
import com.vriche.adrm.util.HandlePropertiesUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.ZipUtil;

public class SimpleServiceImpl implements Serializable,SimpleService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7968010661580671578L;
	
	private static final Logger logger = Logger.getLogger(SimpleServiceImpl.class); 
	
//	private static String tvName;
	
	
	public static final SimpleDateFormat fullYearDateTime = new SimpleDateFormat("yyyyMMdd");
	

	public void testMethod3(){
		logger.info("testMethod2.......2");	
	}
	
//    public SimpleServiceImpl() {
//    	String tvName = SysParamUtil.getTvNameParam();
//    	if(tvName == null||"".equals(tvName)) tvName ="vriche";
//    }
	
	


	
	
  public String getTvName() {
	String tvName = SysParamUtil.getTvNameParam();
	if(tvName == null||"".equals(tvName)||"0".equals(tvName)) tvName ="vriche";
	return tvName;
  }	
   
  public String[] getBackCmd(Properties ps) {
	   String tvName = getTvName();
      String osName = System.getProperty("os.name");

  	
      String host=ps.getProperty("db_host");
      String port=ps.getProperty("db_port");
      String user=ps.getProperty("db_user");
      String pass=ps.getProperty("db_pass");
      String database=ps.getProperty("db_database");
      String path= SysParamUtil.getDatabaseBackPath();
      if(port==null ||port =="") port ="3306";
      
	   File db_path = new File(path);
	    if(!db_path.exists()){  
	    	db_path.mkdir();
	    }	
	    
      String today = fullYearDateTime.format(new java.util.Date());  
      
//      System.out.println("HandlePropertiesUtil.path>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +HandlePropertiesUtil.path);
    
      String fileName =  path + Constants.FILE_SEP + tvName +"_"+today+".sql";
      
      System.out.println("fileName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +fileName);
      
      String binCommand = HandlePropertiesUtil.getInClassBinPath(osName,"mysqldump");
//      String binCommand = HandlePropertiesUtil.path  +"mysqldump";
      
      
      System.out.println("binCommand>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +binCommand);
      
      
      String parameters = "--default-character-set=gbk -u"+user+" -p"+pass+" -h"+host+" -P"+port+" --opt "+database+" > "+ fileName;
      
      System.out.println("parameters>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +parameters);
      
      String[] cmd =new String[3];
      
      if (osName.startsWith("Windows")) {
          if (osName.equals("Windows 95")) { // windows 95 only
          	cmd[0] = "command.com";
          } else {
          	cmd[0] = "cmd.exe";
          }
          cmd[1] =  "/C";
          cmd[2] =  binCommand + " " + parameters;
      } else if (osName.equals("Linux")) {
      	
      	cmd[0]="/bin/sh";
      	cmd[1]="-c";
      	cmd[2]= binCommand + " " + parameters;
      }     

	    return cmd;
}
  
	
  public void sqlDump() throws JobExecutionException {
	  		Properties ps = HandlePropertiesUtil.getDBBackupProperties();
	        String[] cmd = getBackCmd(ps);
	        getLog().info("About to run " + cmd[0] + " " + cmd[1] + " " + (cmd.length>2 ? cmd[2] : "") + " ...");
	        Runtime rt = Runtime.getRuntime();
	        // Executes the command
	        try {
				Process po = rt.exec(cmd);
	
				byte[] error=new byte[1024];
				po.getErrorStream().read(error);		
				int resultCode=po.waitFor();
				if(resultCode==0){
					getLog().info(cmd[0] + " " + cmd[1] + " " + (cmd.length>2 ? cmd[2] : "") +" has already normal terminated.");
					zipFile(ps);
				}else{
					getLog().info(cmd[0] + " " + cmd[1] + " " + (cmd.length>2 ? cmd[2] : "") +" has already abnormal terminated.");
					getLog().warn(" the reason for abnormal terminated is that "+new String(error));
				}			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }  
  
  
  
  public void transfersDB() throws JobExecutionException {
	  
	  
	 try {
	    	
	  ConfigurationLoader.initialize(false);
	  
	  Properties ps= HandlePropertiesUtil.getDBBackupProperties();
	  
      String serviceType = ps.getProperty("serviceType");
      
      System.out.println("serviceType! ---" +serviceType);
      
      
      if("ssh".equals(serviceType)){
      	 ssh(ps);
      }
      
      if("ftp".equals(serviceType)){
      	 ftp(ps);
      }
      
      } catch (Exception e) {
	        e.printStackTrace();
	    }finally {
	        //System.exit(0);
	      }
  }

  
	private void getOldDate(Object[] ls){
		for(int i=0;i<ls.length-1;i++){
			if(Integer.parseInt((String)ls[i])<Integer.parseInt((String)ls[i+1])){
				String temp=(String)ls[i];
				ls[i]=ls[i+1];
				ls[i+1]=temp;
			}
		}
	}



private void ssh(Properties ps)  throws JobExecutionException{
//	 useradd backupuser  -d /db_backup_all -s /bin/bash
	
	
    try {
    	
    	  String tvName = getTvName();
    	
//        int existDate=Integer.parseInt(ps.getProperty("existDate"));
    	  
    	    String existDate="-" + ps.getProperty("existDate");
    	    String preDate = getFileDate(existDate);
    	    
    	    System.out.println("existDate>>>>>>>"+ existDate);
    	    System.out.println("preDate>>>>>>>"+ preDate);
        
        String today = fullYearDateTime.format(new java.util.Date());    	
//	Properties ps=HandlePropertiesUtil.load("qi.properties");
    
    String hostname=ps.getProperty("targ_hostname");
    String username=ps.getProperty("targ_username");
    String password=ps.getProperty("targ_password");
//    String database=ps.getProperty("db_database");
    String path= ps.getProperty("targ_path");    
//    String path2 = ps.getProperty("db_path");  
    String path2= SysParamUtil.getDatabaseBackPath();
    
    String uploadFile = path2+ Constants.FILE_SEP + tvName +"_"+today+".tgz"; 
    
   
    System.out.println("targ_hostname>>>>>>>"+ hostname);
    System.out.println("targ_username>>>>>>>"+ username);
    System.out.println("targ_password>>>>>>>"+ password);
    System.out.println("targ_path>>>>>>>"+ path);
    System.out.println("getDatabaseBackPath>>>>>>>"+ path2);
    System.out.println("ssh uploadFile>>>>>>>"+ uploadFile);
    
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    
    
    File targ_path = new File(uploadFile);
    boolean isPass = targ_path.exists();
    System.out.println("isPass>>>>>>>"+ isPass);


//    boolean isPass = zipFile(ps);
//    
    if(isPass){
    	
	    // Make a client connection
	    SshClient ssh = new SshClient();
	    // Connect to the host
	    ssh.connect(hostname);
	    // Create a password authentication instance
	    PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();
	    // Get the users name
	    pwd.setUsername(username);
	    // Get the password
	    pwd.setPassword(password);
	    // Try the authentication
	    int result = ssh.authenticate(pwd);
	    // Evaluate the result
	    if (result == AuthenticationProtocolState.COMPLETE) {
	      // The connection is authenticated we can now do some real work!
	      SftpClient sftp = ssh.openSftpClient();
	      // Make a directory
	      
	      
//		    File targ_path = new File(path);
//		    if(!targ_path.exists()){  
//		    	targ_path.mkdir();
//		    }	

	      System.out.println("mkdir start >>>>>>>"+ path);
	      sftp.mkdir(path); 
	      System.out.println("mkdir end >>>>>>>"+ path);
	      // Change the mode
//	      sftp.chmod(0755, path);
	      // Change directory
	      sftp.cd(path);
	      
	      System.out.println("mkdir end >>>>>>>"+ path);
	      
	      System.out.println("mkdir start >>>>>>>"+ tvName);
	      sftp.mkdir(tvName);   
//	      sftp.chmod(0755, tvName);
	      sftp.cd(tvName);
	      
	      System.out.println("mkdir end >>>>>>>"+ tvName);

	//   	  //remove file
	      List ls = sftp.ls();

	      
		       for(Iterator it= ls.iterator();it.hasNext();){
		    	    SftpFile file =(SftpFile)it.next();
		    		String filename = file.getFilename();
		    	    long filedt = file.getAttributes().getModifiedTime().longValue()*1000;
			     	String fileDate  = sdf.format(new Date(filedt));
//			     	System.out.println("fileDate2<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>"+ filename);
		     		if(Integer.parseInt(preDate)>Integer.parseInt(fileDate) && filename.startsWith(tvName+"_") && file.isFile()){
		     			sftp.rm(filename);
		     		}	
		       } 
	  

       

	      // Upload a file
		      File file=new File(uploadFile);
		      sftp.put(file.getAbsolutePath());
	      // Quit
	      sftp.quit();
	      ssh.disconnect();
	      
//	      deleteBackSource(ps);
	     
	    }
	    
	    

	  }
    
    }
  catch (Exception e) {
    e.printStackTrace();
  }
  finally {
    //System.exit(0);
  }
  
  
  
}

private String getFileDate(String strAddDays){
	long now =( new Date()).getTime();
	long next = now + Long.parseLong(strAddDays) * 24 * 3600 * 1000;   
	Date dtNext = new Date(next);
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	String strNext = df.format(dtNext);
	return strNext;
}


  	    

private void ftp(Properties ps)  throws JobExecutionException{
    try {
    	String tvName = getTvName();
        String today = fullYearDateTime.format(new java.util.Date());
//	Properties ps=HandlePropertiesUtil.load("qi.properties");
    
//    String serviceType = ps.getProperty("serviceType");
    String server =ps.getProperty("targ_hostname");
    String user =ps.getProperty("targ_username");
    String password =ps.getProperty("targ_password");
//    String database =ps.getProperty("db_database");
    String path = ps.getProperty("targ_path");    
//    String path2 = ps.getProperty("db_path"); 
    String path2= SysParamUtil.getDatabaseBackPath();
    

      String localFile = path2+ Constants.FILE_SEP +tvName+"_"+today+".tgz";
      String remoteFile = path+ Constants.FILE_SEP +tvName+"_"+today+".tgz";
    

    
//    int existDate=Integer.parseInt(ps.getProperty("existDate"));
    String existDate="-" + ps.getProperty("existDate");
    String preDate = getFileDate(existDate);
    

    File targ_path = new File(localFile);
    boolean isPass = targ_path.exists();
    
//  File sour_File = new File(sourFile);
  
  
//  boolean isPass = zipFile(ps);
  
  if(isPass){  

    // Evaluate the result

    FTPClient ftp = new FTPClient();
	ftp.setControlEncoding("UTF-8"); // 中文支持
//	ftp.setConnectTimeout(5000); // 超时设置

	int reply;
	ftp.connect(server);
	System.out.println("Connected to " + server + ".");
	System.out.println(ftp.getReplyString());

//	 After connection attempt, you should check the reply code to verify success.
	reply = ftp.getReplyCode();
	if (!FTPReply.isPositiveCompletion(reply)) {
    	ftp.disconnect();
    	System.err.println("FTP server refused connection.");
    	System.exit(1);
	}

	ftp.login(user, password);
	System.out.println("Login by " + user + ".");
	System.out.println(ftp.getReplyString());

	reply = ftp.getReplyCode();
	if (!FTPReply.isPositiveCompletion(reply)) {
    	ftp.disconnect();
    	System.err.println("Invalid username or password.");
    	System.exit(1);
	} else {
		System.out.println(ftp.getSystemName());

    	FTPClientConfig conf = new FTPClientConfig(ftp.getSystemName().split(" ")[0]);
    	conf.setServerLanguageCode("zh");
    	ftp.configure(conf);

    	ftp.enterLocalPassiveMode(); // Use passive mode as default because most of us are behind firewalls these days.
    	ftp.setFileType(FTP.BINARY_FILE_TYPE); // 二进制文件支持
      // The connection is authenticated we can now do some real work!
    	
      // Make a directory
    	 System.out.println("path1>>>>>>>"+ path);
    	 
    	 path = path+"/"+tvName;
    	 boolean s = checkPathExist(ftp,path,"/");
//    	 System.out.println("checkPathExist>>>>>>>"+ s);
    	 
    	 ftp.changeWorkingDirectory(path);
    	 
    	 //只保留服务器上最近5天的备份，其余删除
    	
    	FTPFile[] files = ftp.listFiles();

     	 for (int i = 0;i<files.length;i++) {
     		FTPFile file = (FTPFile)files[i];
     		String filename = file.getName();
     		String fileDate = fullYearDateTime.format(file.getTimestamp());
     		if(Integer.parseInt(preDate)>Integer.parseInt(fileDate) && filename.startsWith(tvName+"_") && file.isFile()){
     		   ftp.dele(tvName+"_"+ fileDate +".tgz");
     		}
	     }



	
      // Upload a file
	 
	      
	      InputStream in = new FileInputStream(localFile);
//	      ftp.uploadFile(ftp,path,file.getAbsolutePath());
	      
//		 上传本地文件到ftp指定目录
//	 	File uploadFile = new File(path+ File.separator + uploadFileName);
	 	boolean uploaded = ftp.storeFile(remoteFile,in);
	 	System.out.println(uploaded ? "remoteFile " + remoteFile + " upload success" : "localFile " + localFile + " upload failure");
	 	System.out.println(ftp.getReplyString());	      
	      
	      
	  }	  
	
	  deleteBackSource(ps);

    }
  		
  }
  catch (Exception e) {
    e.printStackTrace();
  }
  finally {
    //System.exit(0);
  }
} 
  

/** 
 *   
 * 查找指定目录是否存在  不存在创建目录 
 *  
 * @param FTPClient  
 *    ftpClient 要检查的FTP服务器 
 * @param String  
 *    filePath 要查找的目录  
 * @return  
 *    boolean:存在:true，不存在:false  
 * @throws IOException  
 */  
private static  boolean checkPathExist(FTPClient ftpClient, String filePath,String fileSeq)  
  throws IOException {  
 boolean existFlag = false;  

 try {  
  if (filePath != null && !filePath.equals("")) {  
   if (filePath.indexOf(fileSeq) != -1) {  
    int index = 0;  
    while ((index = filePath.indexOf(fileSeq)) != -1) {  
     if (!ftpClient.changeWorkingDirectory(filePath.substring(0,index))) {  
      ftpClient.makeDirectory(filePath.substring(0,index));  
     }  
     ftpClient.changeWorkingDirectory(filePath.substring(0,index));  
     filePath = filePath.substring(index + 1, filePath.length());  
    }  
    if (!filePath.equals("")) {  
     if (!ftpClient.changeWorkingDirectory(filePath)) {  
      ftpClient.makeDirectory(filePath);  
     }  
    }  
   }   
   existFlag = true;  
  }  
 } catch (Exception e) {  
  e.printStackTrace();  
 }  
 return existFlag;  
}  


private void deleteBackSource(Properties ps){
	 String tvName = getTvName();
	 String today = fullYearDateTime.format(new java.util.Date());

	  String path= SysParamUtil.getDatabaseBackPath();
	  String fileName = tvName+"_"+today;
	  
	  String sourFile = path+ Constants.FILE_SEP + fileName+".sql";
	  String zipFile = path+ Constants.FILE_SEP + fileName +".tgz";
	  
	  File sour=new File(sourFile);
	  if(sour.exists()) sour.delete();
	  
	  File zip=new File(zipFile);
	  if(zip.exists()) zip.delete();	  
}

private synchronized  boolean zipFile(Properties ps){
	String tvName =getTvName();
	 String today = fullYearDateTime.format(new java.util.Date());
 
	  String path2= SysParamUtil.getDatabaseBackPath();
	  
//	  String path = ps.getProperty("targ_path");  
	  
	    String sourFile = path2+ Constants.FILE_SEP +tvName+"_"+today+".sql";
	    String targFile = path2+Constants.FILE_SEP +tvName+"_"+today+".tgz";
	    File sour_File = new File(sourFile);
	    
//	    File targ_path = new File(path);
//	    if(!targ_path.exists()){  
//	    	targ_path.mkdir();
//	    }		    
	    
	    
	    if(sour_File.exists()){  
	        ZipUtil.zip(sourFile,targFile);
	        System.out.println("--- 压缩成功! ---");
	        return true;
	    }else{
	    	 return false;
	    }
}
	    protected  Logger getLog() {
	        return logger;
	    }	
	    
	    
	    public void backup() {  
	        try {   
	        String filePath = System.getProperty("user.dir") + "//"+new Date().getYear()+"-"+new Date().getMonth()+"-"+new Date().getDay()+".sql";//BakMysql.class.getResource("").toString();   
	        System.out.println();   
	            Runtime rt = Runtime.getRuntime();   
	            // 调用 mysql 的 cmd:   
	            Process child = rt.exec("D://Program Files//Apache Software Foundation//xampp//mysql//bin//mysqldump  -uroot -p1234 114la");  
	            // 设置导出编码为utf8。这里必须是utf8   
//	           注意这一句，是指运行mysqldump命令，后面跟的是登录名和登录的密码，接着后面的是指备份的数据库的名字，到此结束，以此生成一个执行的进程，取得此进程的输出流到我们要备份的文件   
	            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行   
	            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流   
	            InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码   
	            String inStr;   
	            StringBuffer sb = new StringBuffer("");   
	            String outStr;   
	            // 组合控制台输出信息字符串   
	            BufferedReader br = new BufferedReader(xx);   
	            while ((inStr = br.readLine()) != null) {   
	                sb.append(inStr + "/r/n");   
	            }   
	            outStr = sb.toString();//备份出来的内容是一个字条串   
	             
	            // 要用来做导入用的sql目标文件：   
	            FileOutputStream fout = new FileOutputStream(filePath);   
	            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");   
	            writer.write(outStr);//写文件   
	            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免   
	            writer.flush();   
	            // 别忘记关闭输入输出流   
	            in.close();   
	            xx.close();   
	            br.close();   
	            writer.close();   
	            fout.close();   
	            System.out.println("");   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	    }  
	    public String backupMySqlToFile() {   
	        String outStr = "";   
	        try {   
	            Runtime rt = Runtime.getRuntime();   
	                Process child = rt.exec("D://Program Files//Apache Software Foundation//xampp//mysql//bin//mysqldump  -uroot -p1234 114la");  
	                // 设置导出编码为utf8。这里必须是utf8在此要注意，有时会发生一个mysqldump:   
	                //Got error: 1045的错误，此时mysqldump必须加上你要备份的数据库的IP地址，即  
	                //mysqldump -h192.168.0.1 -uroot -pmysql dbname，今天我就遇到了这样的问题，呵呵               
	                // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。  
	                //注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行   
	                InputStream in = child.getInputStream();// 控制台的输出信息作为输入流   
	                InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码   
	                String inStr;   
	                StringBuffer sb = new StringBuffer("");   
	                // 组合控制台输出信息字符串   
	                BufferedReader br = new BufferedReader(xx);   
	                while ((inStr = br.readLine()) != null) {   
	                    sb.append(inStr + "/r/n");   
	                }   
	                outStr = sb.toString();   
	                in.close();   
	                xx.close();   
	                br.close();   
	            } catch (Exception e) {   
	                e.printStackTrace();   
	            }   
	            return outStr;   
	        }     
	    public void load() {   
            try {   
                String fPath = "c://test.sql";   
                Runtime rt = Runtime.getRuntime();   
                Process child = rt.exec("D://Program Files//Apache Software Foundation//xampp//mysql//bin//mysql -uroot -p1234 114la");   
                OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流   
                String inStr;   
                StringBuffer sb = new StringBuffer("");   
                String outStr;   
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath), "utf8"));   
                while ((inStr = br.readLine()) != null) {   
                    sb.append(inStr + "/r/n");   
                }   
                outStr = sb.toString();   
                OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");   
                writer.write(outStr);   
                // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免   
                writer.flush();   
                out.close();   
                br.close();   
                writer.close();   
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }   
    //当用户恢复数据的时候，直接传一个上传的文件给这个方法，就可以对数据库进行恢复了   
        public void restoreMysqlFromFile(File f) {   
            try {   
                FileInputStream fis = new FileInputStream(f);   
                Runtime rt = Runtime.getRuntime();   
                Process child = rt.exec("mysql -uroot -p1234 114la");//这里执行的是mysql命令，用户名，密码以及要恢复的数据库，命令执行完后会从我们上传的文件里面读取要执行的内容   
                OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流   
                String inStr;   
                StringBuffer sb = new StringBuffer("");   
                String outStr;   
                BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf8"));   
                while ((inStr = br.readLine()) != null) {   
                    sb.append(inStr + "/r/n");   
                }   
                outStr = sb.toString();   
                OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");   
                writer.write(outStr);   
                // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免   
                writer.flush();   
                out.close();   
                br.close();   
                writer.close();   
                fis.close();   
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }   
	
}
