package com.vriche.adrm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import com.vriche.adrm.Constants;

public class HandlePropertiesUtil{
	
public static String path=HandlePropertiesUtil.class.getResource("/").getPath();
	
	public static Properties load(String url){
//		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		String realPath=path.substring(0,path.length()-8);
		
		Properties pt=new Properties();
		try {
			pt.load(new FileInputStream(realPath+url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pt;
	}
	
	public static Properties  getDBBackupProperties(){
    	return loadFromClass(Constants.DATABASE_BACKUP_PROPERTIES_FILE_NAME);
    	
	}
	
	public static String  getInClassBinPath(String osName,String fileName){
		  String commandPath= fileName;
		  ClassLoader cl = Thread.currentThread().getContextClassLoader();
		  String url = ""+cl.getResource(fileName);
		  
		  if (osName.startsWith("Windows")) {
			  if(url!=null) commandPath = url.substring(6);
		  }else if (osName.equals("Linux")) {
			  if(url!=null) commandPath=url.substring(5);
		  }
		  
		  
		  return commandPath;
	}
	
	
	
	
	
	public static Properties loadFromClass(String fileName){
	      Properties ps = new Properties(); 
		  ClassPathResource resource = new ClassPathResource(fileName);
		
	      try {
		    InputStream in = resource.getInputStream();
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      

		return ps;
	}
	
	
	
	
	public static void savDatabaseBackupProperty(Properties propertie) {  
		String description ="#";
		saveProperty(Constants.DATABASE_BACKUP_PROPERTIES_FILE_NAME,propertie, description);
	}
	
	public static void saveProperty(String fileName,Properties propertie,String description) {  
		         // 保存文件  
		      
		         ClassPathResource resource = new ClassPathResource(fileName);
		         
		        
		         try {  
		             FileOutputStream outputFile = new FileOutputStream(resource.getFile().getPath());  
		             propertie.store(outputFile, description);// property类关键的store方法  
		             outputFile.close();  
		             // propertie.list(System.out);  
		             System.out.println("File was saved!");  
		         } catch (FileNotFoundException e) {  
		             e.printStackTrace();  
		         } catch (IOException ioe) {  
		             ioe.printStackTrace();  
		         }  
		     }  
	

	public static void save(String url,Properties pt){
		OutputStream os = null;
//		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		String realPath=path.substring(0,path.length()-8);
		try {
			os = new FileOutputStream(realPath+url);
			pt.store(os,null);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			os=null;
			pt=null;
		}	
	}
}