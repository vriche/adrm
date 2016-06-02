package com.vriche.adrm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.SysParam;

public class FileUtil {
	
	public static String getUploadDir(){
		 return (String)Constants.APPLACTION_MAP.get(Constants.FILE_ADVERS_DIR);
	}
	
	public static boolean isFileDir(String dir){
		try{
		   File dirPath = new File(dir);
		   if (!dirPath.exists()) dirPath.mkdirs();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
      
	  /**
	   * 压缩文件
	   * @param srcfile File[]  需要压缩的文件列表
	   * @param zipfile File    压缩后的文件
	   */
    
	  public static void ZipFiles(java.io.File[] srcfile, File zipfile) {
		byte[] buffer = new byte[1024];
		int bytesRead = 0; //读输入文件的字节数  
		try {
		    // Create the ZIP file
		    ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipfile));
		    // Compress the files
		    for (int i = 0; i < srcfile.length; i++) {
		      FileInputStream in = new FileInputStream(srcfile[i]);
		      // Add ZIP entry to output stream.
		      zip.putNextEntry(new ZipEntry(srcfile[i].getName()));
		      // Transfer bytes from the file to the ZIP file

			  while ((bytesRead = in.read(buffer)) != -1)
					zip.write(buffer, 0, bytesRead);
		      // Complete the entry
			  zip.closeEntry();
		      in.close();
		    }
		    // Complete the ZIP file
		    zip.close();
		    System.out.println("压缩完成.");
		  }
		  catch (IOException e) {
		    e.printStackTrace();
		  }
	  }
	

	
	 	
//	public static void saveFile(String dir,String fileName,List advers){
//		String newline = "\r\n";
//
//		File file = new File(dir,fileName+".txt");
//
//			try {
//				BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));
//				for(Iterator it = advers.iterator();it.hasNext();){
//					String[] adverStr = (String[])it.next();
//					
//					for(int j = 0; j < adverStr.length; j++){
//						bw.write(adverStr[j]);
//						bw.write(newline);
//					}
//				}
//				bw.flush();
//				bw.close();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	}	
//	
	  
		public static void saveFile3(String dir,String fileName,List advers){
			
			File file = new File(dir,fileName+".xml");

			Map<String,String> ftpConf = (Map<String,String>) Constants.APPLACTION_MAP.get(Constants.FTP_SERVVICE_CONFIG);
			
			System.out.println("ftpConf.get(ip)>>>>>>>>>>>>>" +ftpConf.get("ip"));
			
			String server = ftpConf.get("ip");  
			String port = ftpConf.get("port");
			String user = ftpConf.get("user");
			String pass = ftpConf.get("pass");	
			
			System.out.println("ftpConf>>>>>>>>>>>>>" + server +">>"+port+">>"+user+">>"+pass);

				try {
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
					for(Iterator it = advers.iterator();it.hasNext();){    
						String adverStr = (String)it.next();
//						for(int j = 0; j < adverStr.length; j++){
							bw.write(adverStr);
//							bw.write(newline);
//						}
					}
					bw.flush();
					bw.close();
					
					
					FTP ftp = new FTP(user, pass, server, Integer.valueOf(port));
					ftp.connectServer();
					System.out.println(">>>>>"+file.getAbsolutePath());  
					ftp.upFile(Constants.FILE_SEP, file.getName(), file.getAbsolutePath());
					ftp.closeConnect();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}

		}	
		
		
		
		
		public static void saveFile4(String dir,String fileName,List advers){
			
			File file = new File(dir,fileName+".xml");

				try {
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));
					for(Iterator it = advers.iterator();it.hasNext();){    
						String adverStr = (String)it.next();

//						for(int j = 0; j < adverStr.length; j++){
							bw.write(adverStr);
//							bw.write(newline);
//						}
					}
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}

		}			
		
		
		
		public static void saveFile(String dir,String fileName,List advers){
//			String newline = "\r\n";

			File file = new File(dir,fileName+".txt");

				try {
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));
					for(Iterator it = advers.iterator();it.hasNext();){
						String adverStr = (String)it.next();

//						for(int j = 0; j < adverStr.length; j++){
							bw.write(adverStr);
//							bw.write(newline);
//						}
					}
					bw.flush();
					bw.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}	
		
		
	public static void zipFile(String srcDir,String fileName){
//		File[] fs = new File(dir).listFiles();
//		File zf = new File(dir,fileName+".zip");
//		ZipFiles(fs,zf);
//		System.out.println("srcDir>>>>>>>>>>>"+srcDir);
		try {
			zip(srcDir,getZipDir()+Constants.FILE_SEP +fileName+".zip");
//			zip(srcDir,getZipDir());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listFile(String baseDir){
		String[] mydir = new java.io.File(baseDir).list(new FileZipFilter()); 
//		System.out.println(">>>>>>>>>>>>>" +mydir.length);
		java.util.Arrays.sort(mydir);  
		 for (int i=0; i<mydir.length;i++){
			 System.out.println(mydir[i]); 
		 }
	}	
	

	public static String  getDirTxt(String carrier, Object[] resources, Integer publishDate,int type){
		String myDir = getUploadDir();
		myDir += Constants.FILE_SEP +"TXT";

		myDir +=  Constants.FILE_SEP + publishDate + Constants.FILE_SEP;
		String carriers[] = carrier.split("_");	
		

		if(type == 1){
			if(carriers.length > 0) myDir += carriers[0];
//            String level1 = carriers[0];   //频道名称
//            String level2 = carriers[1];   //类别一 如 白天
//            String level3 = carriers[2];   //类别一 如 平播
		}
		
		if(type == 2){
			for(int i = 0;i<carriers.length;i++){
				myDir += carriers[i];
				if(i < carriers.length-1)myDir +=  Constants.FILE_SEP;
			}
		}
//		if(type == 3){
//			for(int i = 0;i<carriers.length;i++){
//				myDir += carriers[i];
//				if(i < carriers.length-1)myDir +=  Constants.FILE_SEP;
//			}
//		}
		File dirPath = new File(myDir);
		if (!dirPath.exists()) dirPath.mkdirs();
		
		return myDir;
	}
	
	public static String  getDateDir(Integer publishDate){
		String myDir = getUploadDir();
		myDir += Constants.FILE_SEP +"TXT";
        myDir +=  Constants.FILE_SEP + publishDate;    
 		File dirPath = new File(myDir);     
		if (!dirPath.exists()) dirPath.mkdirs(); 
		return myDir;
	}
	
	public static String  getZipDir(){
		String myDir = getUploadDir();
		myDir += Constants.FILE_SEP +"ZIP";
//        myDir +=  Constants.FILE_SEP + publishDate;
 		File dirPath = new File(myDir);
		if (!dirPath.exists()) dirPath.mkdirs();
		return myDir;
	}
	
	public static String  getFileName(String carrier, Object[] resources, Integer publishDate){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		int carrierNodeLevel = sysParam.getCarrierNodeLevelParam()==null?0:new Integer(sysParam.getCarrierNodeLevelParam()).intValue();
		String fileName ="";
	
	
			
			String carriers[] = carrier.split("_");
//            String level1 = carriers[0];   //频道名称
//            String level2 = carriers[1];   //类别一 如 白天
//            String level3 = carriers[2];   //类别一 如 平播
            for(int i=1;i<carrierNodeLevel;i++){
            	 fileName += carriers[i];
            }
		

		return fileName + publishDate.toString().substring(2,8);
	}
	
	public static String  getFileName3(String carrierName, Object[] resources, Integer publishDate){
		//SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		//int carrierNodeLevel = sysParam.getCarrierNodeLevelParam()==null?0:new Integer(sysParam.getCarrierNodeLevelParam()).intValue();
		String fileName ="TB";
		String channelId="";
		List carriers = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
		for(Iterator it=carriers.iterator();it.hasNext();){
			Carrier channel=(Carrier)it.next();
			if(channel.getCarrierName().equals(carrierName))
					channelId=channel.getChannelId().toString();
		}
			if(channelId.length()<10) channelId="0"+channelId;
//			String carriers[] = carrier.split("_");
////            String level1 = carriers[0];   //频道名称
////            String level2 = carriers[1];   //类别一 如 白天
////            String level3 = carriers[2];   //类别一 如 平播
//            for(int i=1;i<carrierNodeLevel;i++){
//            	 fileName += carriers[i];
//            }
		

		return fileName + publishDate.toString()+channelId;
	}

	public static void zip(String inputFileName,String zipFileName) throws Exception {
//		String zipFileName="c:\\test.zip";//打包后文件名字
//		 zipFileName="c:\\test.zip";//打包后文件名字
//		System.out.println(zipFileName);
		zip(zipFileName, new File(inputFileName));

	}
	
	private static void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		out.setEncoding("GBk");
		zip(out, inputFile, "");
		System.out.println("zip done");
		out.close();
	}
	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
//		if (f.isDirectory()) {
//			File[] fl = f.listFiles();
//			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
//			base = base.length() == 0 ? "" : base + Constants.FILE_SEP;
////			base = base.length() == 0 ? "" : base + "/";
//			for (int i = 0; i < fl.length; i++) {
//				zip(out, fl[i], base + fl[i].getName());
//			}
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
            zip(out, fl[i], base + fl[i].getName());
          }
		}else {
		    
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "iso8859-1"));	
            
			int b;
//			System.out.println(base);
			while ( (b = in.read()) != -1) {
					out.write(b);
			}
			in.close();
//			System.out.println("压缩完成.");
		}
	}	
}


