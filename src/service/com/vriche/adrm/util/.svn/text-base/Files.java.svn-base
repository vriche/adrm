package com.vriche.adrm.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





public class Files {

	private static Log log=LogFactory.getLog(Files.class);
    /** Creates a new instance of FileMan */
    public Files() {
        fileSepa=System.getProperty("file.separator");
        //System.out.print("separator:"+fileSepa+"\n");
    }
    public static String getSeparator(){
        return fileSepa;
    }
    /** Get System default Encoding */
    public static String getDefaultEncoding(){
        String temp=System.getProperty("file.encoding");
        return temp;
    }
    /** Get File list */
    public void getList(String strPath){
    	File files=new File(strPath);
        if(files.isDirectory()){
            File listFile[]=files.listFiles();
            for(int i=0;i<listFile.length;i++){
                System.out.print(listFile[i].getName()+":"+listFile[i].getPath()+"\n");
            }
        }
    }
    /** make dir */
    public static boolean mkdir(String strPath){
        try{
        	File files=new File(strPath.toString());
            if(!files.exists()){
                files.mkdir();
                if(log.isInfoEnabled()) {
                    log.info("Make dir "+strPath);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("Make dir "+strPath+" error"+e.getMessage());
        }
        return true;
    }
    
    
    public static boolean mkFile(String strPath){
    	File file=new File(strPath);
    	if(!file.exists())
    	{
    		try {
    			file.createNewFile();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
        return true;
    }   
    
    public static boolean checkFile(String strPath,String filename){
    	mkdir(strPath);
    	mkFile(filename);
        return true;
    }   
    
    
    /** Delete File */
    public boolean deleFile(String strPath){
        try{
            files=new File(strPath.toString());
            if(files.exists()){
                files.delete();
                if(log.isInfoEnabled()) {
                    log.info("delete File "+strPath);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("delete File "+strPath+" error"+e.getMessage());
        }
        return true;
    }
    /** Create New File */
    public boolean createFile(String strPath,String content){
        BufferedWriter bw=null;
        try{
            files=new File(strPath.toString());
            bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(files), "GBK"));
            bw.write(content,0,content.length());
            bw.flush();
            if(log.isInfoEnabled()) {
                log.info("Create File "+strPath);
            }
        } catch(IOException e){
            log.error("File write "+strPath+" error"+e.getMessage());
            return false;
        } finally{
            try{
                bw.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        return true;
    }
    /** Read File */
    public String readFile(String filepath) throws FileNotFoundException {
        String returnStr="";
        BufferedReader br=null;
        try{
            files=new File(filepath.toString());
            InputStreamReader read =new InputStreamReader(new FileInputStream(files),"GBK");
            //BufferedReader br=new BufferedReader(new FileReader(filepath.toString()));
            br=new BufferedReader(read);
            String line=null;
            line=br.readLine();
            while(line!=null){
                returnStr=returnStr+line+"\n\r";
                line=br.readLine();
            }
        } catch(IOException e){
            System.out.println("file open error"+e.getMessage());
        }
        finally{
            try{
                br.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        if(returnStr==null){
            return "file is empty";
        } else{
            return returnStr;
        }
    }
    /*
    public static void main(String args[]){
        Files f=new Files();
        String temp="";
        try{
            temp=f.readFile("C:\\Program Files\\test.htm");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.print(temp);
       }
     **/
    File files=null;
    public static String fileSepa=null;
    
    
    public static File getFileFromInputStream(String fileName) {
    	ClassLoader cl = Thread.currentThread().getContextClassLoader();
    	URL url = cl.getResource(fileName);
    	if (url != null) {
	    	File file = new File(url.getFile());
	    	return file;
    	}
    	else {
    		return null;
    	}
    } 
    
    
    public String read(String fileName) throws IOException {
		return read(new File(fileName));
	}

	public String read(File file) throws IOException {
		return read(file, false);
	}

	public String read(File file, boolean raw) throws IOException {
		FileInputStream fis = new FileInputStream(file);

		byte[] bytes = new byte[fis.available()];

		fis.read(bytes);

		fis.close();

		String s = new String(bytes, StringPool.UTF8);

		if (raw) {
			return s;
		}
		else {
			return StringUtil.replace(
				s, StringPool.RETURN_NEW_LINE, StringPool.NEW_LINE);
		}
	}   
    
	public void write(String fileName, String s) throws IOException {
		write(new File(fileName), s);
	}

	public void write(String fileName, String s, boolean lazy)
		throws IOException {

		write(new File(fileName), s, lazy);
	}

	public void write(String fileName, String s, boolean lazy, boolean append)
		throws IOException {

		write(new File(fileName), s, lazy, append);
	}

	public void write(String pathName, String fileName, String s)
		throws IOException {

		write(new File(pathName, fileName), s);
	}

	public void write(String pathName, String fileName, String s, boolean lazy)
		throws IOException {

		write(new File(pathName, fileName), s, lazy);
	}

	public void write(
			String pathName, String fileName, String s, boolean lazy,
			boolean append)
		throws IOException {

		write(new File(pathName, fileName), s, lazy, append);
	}

	public void write(File file, String s) throws IOException {
		write(file, s, false);
	}

	public void write(File file, String s, boolean lazy)
		throws IOException {

		write(file, s, lazy, false);
	}

	
	public void mkdirs(String pathName) {
		File file = new File(pathName);

		file.mkdirs();
	}

	
	public void write(File file, String s, boolean lazy, boolean append)
		throws IOException {

		if (file.getParent() != null) {
			mkdirs(file.getParent());
		}

		if (lazy && file.exists()) {
			String content = read(file);

			if (content.equals(s)) {
				return;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(file, append), StringPool.UTF8));

		bw.write(s);

		bw.close();
	}

	public void write(String fileName, byte[] bytes) throws IOException {
		write(new File(fileName), bytes);
	}

	public void write(File file, byte[] bytes) throws IOException {
		if (file.getParent() != null) {
			mkdirs(file.getParent());
		}

		FileOutputStream fos = new FileOutputStream(file);

		fos.write(bytes);

		fos.close();
	}

	public void write(String fileName, InputStream is) throws IOException {
		write(fileName, getBytes(is));
	}

	public void write(File file, InputStream is) throws IOException {
		write(file, getBytes(is));
	}   
	public byte[] getBytes(File file) throws IOException {
		if ((file == null) || !file.exists()) {
			return null;
		}

		FileInputStream is = new FileInputStream(file);

		byte[] bytes = getBytes(is, (int)file.length());

		is.close();

		return bytes;
	}

	public byte[] getBytes(InputStream is) throws IOException {
		return getBytes(is, -1);
	}

	public byte[] getBytes(InputStream is, int bufferSize) throws IOException {
		ByteArrayMaker bam = null;

		if (bufferSize <= 0) {
			bam = new ByteArrayMaker();
		}
		else {
			bam = new ByteArrayMaker(bufferSize);
		}

		boolean createBuffered = false;

		try {
			if (!(is instanceof BufferedInputStream)) {
				is = new BufferedInputStream(is);

				createBuffered = true;
			}

			int c = is.read();

			while (c != -1) {
				bam.write(c);

				c = is.read();
			}
		}
		finally {
			if (createBuffered) {
				is.close();
			}
		}

		bam.close();

		return bam.toByteArray();
	}
}
