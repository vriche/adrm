package com.vriche.adrm.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 文件FTP上传基类
 *
 * @author : 龚成伟(Elwin)
 * @createDate: Dec 26, 2007-4:57:47 PM
 * @version $Revision: 1.1 $
 *
 */
public class ApacheCommonNettoFtpBase {
 private static String ip;
 private static String user;
 private static String password;
 private static int port;
 private static FTPClient ftpClient;
 
 /**
  * 初始化
  * @param ip FTP服务器地址
  * @param user 服务名
  * @param password 密码
  * @param port 端口号
  */
 public ApacheCommonNettoFtpBase(String ip,String user,String password,int port){
  this.ip=ip;
  this.user=user;
  this.password=password;
  this.port=port;
 }
 
 /**
  * 上传文件
  * @param file 文件
  * @return
  */
 public boolean uploadFile(File file){
  if (!file.isFile()) {
   //不是文件
   return false;
  }else if(!fileSize(file)){
   //控制文件大小
   return false;
  }
  
  //
  if (!connectServer()) {
   return false;
  }
  
  //给文件加上时间撮,防止服务器文件重复
  String fileName=file.getName();
  int lastIndex=fileName.lastIndexOf(".");
  fileName=fileName.substring(0,lastIndex)+"_"+System.currentTimeMillis()+fileName.substring(lastIndex);
  
  try {
   FileInputStream fis=new FileInputStream(file);
   if(!ftpClient.storeFile(gbktoiso8859(fileName), fis)){
    closeConnect();
    return false;
   }
  } catch (IOException e) {
   e.printStackTrace();
   return false;
  }finally{
   closeConnect();
  }
  
  return true;
 }
 
 /**
  * 上传文件
  * @param file 文件
  * @param path 上传服务器路径
  * @return
  */
 public boolean uploadFile(File file,String path){
  //转到path路径
  path=this.pathAddress(path);
  //创建路径
  mkdir(path);
  //进入服务器目录
  if (!this.changeWorkingDirectory(path)) {
   return false;
  }
  
  return uploadFile(file);
 }
 
 /**
  * 下载文件
  * @param filename 文件名
  * @return
  */
 public InputStream downloadFile(String filename){
  if (!connectServer()) {
   return null;
  }
  InputStream is=null;
  try {
   is=ftpClient.retrieveFileStream(gbktoiso8859(filename));
   return is;
  } catch (IOException e) {
   e.printStackTrace();
   closeConnect();
   return null;
  }
  //退出FTP服务器
  //不能马上退出,不然会出现文件下载到一半,没有下载完整的情况
  //this.closeConnect();
 }
 
 /**
  * 下载文件
  * @param filename 文件名
  * @param path 路径
  * @return
  */
 public InputStream downloadFile(String filename,String path){
  //转到path路径
  path=this.pathAddress(path);
  if (!this.changeWorkingDirectory(path)) {
   return null;
  }
  
  return downloadFile(filename);
 }
 /**
  * 删除文件
  * @param path  路径
  * @param filename 文件名
  * @return
  */
 public boolean deleteFile(String filename,String path){
  
  //转到path路径
  path=this.pathAddress(path);
  if (!this.changeWorkingDirectory(path)) {
   return false;
  }
  //删除文件
  return deleteFile(filename);
 }
 /**
  * 删除文件
  *
  * @param filename 文件名
  * @return
  */
 public boolean deleteFile(String filename) {
  try {
   if (!connectServer()) {
    return false;
   }
   return ftpClient.deleteFile(gbktoiso8859(filename));
  } catch (IOException ioe) {
   ioe.printStackTrace();
   closeConnect();
   return false;
  }
 }
 
 /**
  * 文件列表 显示path目录下载文件夹和文件
  * @param path
  */
 public void fileList(String path){
  try {
   path=pathAddress(path);
   if (connectServer()) {
    FTPFile[] vFiles = ftpClient.listFiles(gbktoiso8859(path));
             for (int i = 0; i < vFiles.length; i++) {
     if(vFiles[i] != null) {
      System.out.println(iso8859togbk(vFiles[i].getRawListing()));
     }
    }
   }
  } catch (IOException e) {
   e.printStackTrace();
  }finally{
   // 退出FTP服务器
   this.closeConnect();
  }
  
 }
 
 /**
  * 创建路径
  * @param path 路径名称
  * @return
  */
 public boolean mkdir(String path){
  if (!connectServer()) {
   return false;
  }
  try{
   path=this.pathAddress(path);
   return ftpClient.makeDirectory(gbktoiso8859(path));
  }catch(IOException e){
   e.printStackTrace();
   return false;
  }
 }
 /**
  * 重命名文件
  * @param oldFileName --原文件名
  * @param newFileName --新文件名
  */
 public  boolean  renameFile(String oldFileName, String newFileName) {
  try {
   if (!connectServer()) {
    return false;
   }
   return ftpClient.rename(gbktoiso8859(oldFileName), gbktoiso8859(newFileName));
  } catch (IOException ioe) {
   ioe.printStackTrace();
   closeConnect();
   return false;
  }
 }
 /**
  * 进入到服务器的某个目录下
  * @param directory
  */
 public  boolean changeWorkingDirectory(String directory) {
  try {
   if (!connectServer()) {
    return false;
   }
   return ftpClient.changeWorkingDirectory(gbktoiso8859(directory));
  } catch (IOException ioe) {
   ioe.printStackTrace();
   return false;
  }
 }
 /**
  * 返回到上一层目录
  */
 public  boolean changeToParentDirectory() {
  try {
   if (!connectServer()) {
    return false;
   }
   return ftpClient.changeToParentDirectory();
  } catch (IOException ioe) {
   ioe.printStackTrace();
   closeConnect();
   return false;
  }
 }

 /**
  * 登录ftp服务器
  *
  */
 public boolean connectServer() {
  
  if (ftpClient==null) {
   try {
    ftpClient=new FTPClient();
    //所有使用iso-8859-1做为通讯编码集
    //ftpClient.setControlEncoding("iso-8859-1");
    //ftpClient.configure(getFTPClientConfig());
    
    ftpClient.connect(ip,port);
    
    if (!ftpClient.login(user, password)) {
     //登录失败
     return false;
    }
    //状态
    int reply = ftpClient.getReplyCode();
    if (!FTPReply.isPositiveCompletion(reply)) {
     closeConnect();
     return false;
    }
    
    //  用被动模式传输
    ftpClient.enterLocalPassiveMode();
    // 将文件传输类型设置为二进制
    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    //防止server超时断开
    //ftpClient.setDefaultTimeout(60000);
    //10连接超时
    ftpClient.setSoTimeout(10000);
   }catch(SocketException se){
    se.printStackTrace();
    return false;
   } catch (Exception e) {
    e.printStackTrace();
    return false;
   }
  }
  return true;
 }
 
 /**
  * 关闭连接
  */
 private  void closeConnect() {
  try {
   if (ftpClient != null) {
    ftpClient.logout();
    ftpClient.disconnect();
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 /**
  * 写文件到本地
  * @param is 文件流
  * @param allPath 全路径=文件路径+文件名
  * @return
  */
 public boolean writeFile(InputStream is,String allPath){
  if (is==null || allPath==null) {
   return false;
  }
  try {
   //默认也是2048
   int buffered=2048;
   BufferedInputStream bis=new BufferedInputStream(is,buffered);
   BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(allPath));
   final byte[] bytes = new byte[2048];
   int c;
   while ((c = bis.read(bytes)) != -1) {
    bos.write(bytes);
   }
      //将缓冲区中的数据全部写出
   bos.flush();
   //关闭流
   bis.close();
   bos.close();
   return true;
  } catch (Exception e) {
   e.printStackTrace();
   return false;
  }
 }
 /**
  * 写文件到本地
  * @param is 文件流
  * @param path 文件路径
  * @param filename 文件名
  * @return
  */
 public boolean writeFile(InputStream is,String path,String filename){
  path=pathAddress(path);
  return writeFile(is, path+filename);
 }
 /**
  * 写文件到本地
  * @param file 文件
  * @param path 写到的路径
  * @return
  */
 public boolean writeFile(File file,String path){
  if (!file.isFile()) {
   return false;
  }
  try {
   FileInputStream is=new FileInputStream(file);
   path=pathAddress(path);
   this.writeFile(is, path+file.getName());
  } catch (IOException e) {
   e.printStackTrace();
  }
  
  
  return true;
 }
 /**
  * 设置FTP客服端的配置--一般可以不设置
  * @return
  */
 private static FTPClientConfig getFTPClientConfig() {
  FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
  conf.setServerLanguageCode("zh");
  
  return conf;
 }
 
 /**
  * 控制文件的大小,默认为5M
  * @param file_in 文件
  */
 private boolean fileSize(File file_in) {
  return this.fileSize(file_in,5);
 }
 
 /**
  * 控制文件的大小
  * @param file_in 文件
  * @param size 文件大小,单位为M
  */
 private boolean fileSize(File file_in,int size) {
  if (file_in == null || file_in.length() == 0) {
   //文件为空
   return false;
  } else {
   if (file_in.length() > (1024 * 1024 * size)){
    //文件大小不能大与size
    return false;
   }
  }
  return true;
 }
 /**
  * 格式化文件路径 检查path最后有没有分隔符'\'
  * @param path
  * @return
  */
 public String pathAddress(String path){
  
  if (path==null || path.length()<1) {
   return "";
  }
  String temp_path=path.substring(path.length()-1);
  if (!temp_path.equals("/") && !temp_path.equals("\\")) {
   temp_path=path+File.separator;
  }else{
   temp_path=path;
  }
  return temp_path;
  
 }
 
 /**
  * 转码[ISO-8859-1 ->  GBK]
  *不同的平台需要不同的转码
  * @param obj
  * @return
  */
 private static String iso8859togbk(Object obj) {
  try {
   if (obj == null)
    return "";
   else
    return new String(obj.toString().getBytes("iso-8859-1"), "GBK");
  } catch (Exception e) {
   return "";
  }
 }
 
 /**
  * 转码[GBK ->  ISO-8859-1]
  *不同的平台需要不同的转码
  * @param obj
  * @return
  */
 private static String gbktoiso8859(Object obj) {
  try {
   if (obj == null)
    return "";
   else
    return new String(obj.toString().getBytes("GBK"), "iso-8859-1");
  } catch (Exception e) {
   return "";
  }
 }
 
 public static String getIp() {
  return ip;
 }
 public static void setIp(String ip) {
  ApacheCommonNettoFtpBase.ip = ip;
 }
 public static String getUser() {
  return user;
 }
 public static void setUser(String user) {
  ApacheCommonNettoFtpBase.user = user;
 }
 public static String getPassword() {
  return password;
 }
 public static void setPassword(String password) {
  ApacheCommonNettoFtpBase.password = password;
 }
 public static int getPort() {
  return port;
 }
 public static void setPort(int port) {
  ApacheCommonNettoFtpBase.port = port;
 }
 
 /**
  * 测试
  * @param args
  */
 public static void main(String[] args) {
  String ip="155.222.30.137";
  String user="elwin";
  String password="elwin";
  int port=21;
  String path="f:";
  File file=new File("d:"+File.separator+"银团社团贷款_1451877459518.doc");
  ApacheCommonNettoFtpBase ftp=new ApacheCommonNettoFtpBase(ip,user,password,port);
  //ftp.uploadFile(file,"创建目录");
  //InputStream is=ftp.downloadFile("银团社团贷款_1451877459518_1198723453937.doc","创建目录");
  //ftp.writeFile(is, "F:", "银团社团贷款.doc");
  //ftp.deleteFile("银团社团贷款_1451877459518_1198658605453.doc","创建目录");
  //ftp.ftpfileList(path);
  //ftp.fileList("");
  long l1=System.currentTimeMillis();
  ftp.writeFile(file, path);
  System.out.println(System.currentTimeMillis()-l1);
  
  try{
   long l2=System.currentTimeMillis();
   BufferedRandomAccessFile braf=new BufferedRandomAccessFile(file,"rw");
   File f=new File("F:"+File.separator+"sdfsdf.doc");
   f.createNewFile();
   
   BufferedRandomAccessFile b=new BufferedRandomAccessFile(f,"rw");
   final byte[] bytes = new byte[1024];
   int c;
   while ((c = braf.read(bytes)) != -1) {
    b.write(bytes,0,c);
   }
   System.out.println(System.currentTimeMillis()-l2);
  }catch(Exception e){
   e.printStackTrace();
  }
 }
}
