package com.vriche.adrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.vriche.adrm.Constants;

import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

/**
 * @author 南山一根葱
 * @Description ftp操作
 */
public class UploadUtil {
 /**
  * 获取Ftp目录下的列表
  */
// public void getftpList() {
//  String server = "172.17.6.99";// 输入的FTP服务器的IP地址
//  String user = "linux";// 登录FTP服务器的用户名
//  String password = "linux";// 登录FTP服务器的用户名的口令
//  String path = "/";// FTP服务器上的路径
//  try {
//   FtpClient ftpClient = new FtpClient();// 创建FtpClient对象
//   ftpClient.openServer(server);// 连接FTP服务器
//   ftpClient.login(user, password);// 登录FTP服务器
//   if (path.length() != 0) {
//    ftpClient.cd(path);
//   }
//   TelnetInputStream is = ftpClient.list();
//   int c;
//   while ((c = is.read()) != -1) {
//    System.out.print((char) c);
//   }
//   is.close();
//   ftpClient.closeServer();// 退出FTP服务器
//  } catch (IOException ex) {
//   System.out.println(ex.getMessage());
//  }
// }
// /**
//  * 下载FTP上的文件
//  */
// public void getFtpFile() {
//  String server = "";// 输入的FTP服务器的IP地址
//  String user = "";// 登录FTP服务器的用户名
//  String password = "";// 登录FTP服务器的用户名的口令
//  String path = "";// FTP服务器上的路径
//  String filename = "";// 下载的文件名
//  try {
//   FtpClient ftpClient = new FtpClient();
//   ftpClient.openServer(server);
//   ftpClient.login(user, password);
//   if (path.length() != 0)
//    ftpClient.cd(path);
//   ftpClient.binary();
//   TelnetInputStream is = ftpClient.get(filename);
//   File file_out = new File(filename);
//   FileOutputStream os = new FileOutputStream(file_out);
//   byte[] bytes = new byte[1024];
//   int c;
//   while ((c = is.read(bytes)) != -1) {
//    os.write(bytes, 0, c);
//   }
//   is.close();
//   os.close();
//   ftpClient.closeServer();
//  } catch (IOException ex) {
//   System.out.println(ex.getMessage());
//  }
// }
 /**
  * 上传文件到FTP
  */
 public static void putFtpFile(String server,String user,String pass,String publishDate) {
  String path = "";     
  String fileName = FileUtil.getDateDir(new Integer(publishDate));
  try {
   FtpClient ftpClient = new FtpClient(); 
   ftpClient.openServer(server);
   ftpClient.login(user, pass);
   if (path.length() >0)  
	   ftpClient.cd(path);                
   ftpClient.binary();
     
   File file_in = new File(fileName);  
   File[] file = file_in.listFiles();
   
   for(int i=0;i<file.length;i++){System.out.println("!@!@="+file[i].getAbsolutePath()+">>"+file[i].getCanonicalPath());  
	   TelnetOutputStream os = ftpClient.put(file[i].getName());                  
	   System.out.println("XXX="+file[i].getName());   
	   FileInputStream is = new FileInputStream(file[i]); System.out.println("sss="+is.available());     
	   byte[] bytes = new byte[1024];            
	   int c;
	   while ((c = is.read(bytes)) != -1) { 
	    os.write(bytes, 0, c);  
	   }
	   is.close();
	   os.close();
   } 
   ftpClient.closeServer();
  } catch (IOException ex) { 
   System.out.println(ex.getMessage());
  }
 }
} 