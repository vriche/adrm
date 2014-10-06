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
 * @author ��ɽһ����
 * @Description ftp����
 */
public class UploadUtil {
 /**
  * ��ȡFtpĿ¼�µ��б�
  */
// public void getftpList() {
//  String server = "172.17.6.99";// �����FTP��������IP��ַ
//  String user = "linux";// ��¼FTP���������û���
//  String password = "linux";// ��¼FTP���������û����Ŀ���
//  String path = "/";// FTP�������ϵ�·��
//  try {
//   FtpClient ftpClient = new FtpClient();// ����FtpClient����
//   ftpClient.openServer(server);// ����FTP������
//   ftpClient.login(user, password);// ��¼FTP������
//   if (path.length() != 0) {
//    ftpClient.cd(path);
//   }
//   TelnetInputStream is = ftpClient.list();
//   int c;
//   while ((c = is.read()) != -1) {
//    System.out.print((char) c);
//   }
//   is.close();
//   ftpClient.closeServer();// �˳�FTP������
//  } catch (IOException ex) {
//   System.out.println(ex.getMessage());
//  }
// }
// /**
//  * ����FTP�ϵ��ļ�
//  */
// public void getFtpFile() {
//  String server = "";// �����FTP��������IP��ַ
//  String user = "";// ��¼FTP���������û���
//  String password = "";// ��¼FTP���������û����Ŀ���
//  String path = "";// FTP�������ϵ�·��
//  String filename = "";// ���ص��ļ���
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
  * �ϴ��ļ���FTP
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