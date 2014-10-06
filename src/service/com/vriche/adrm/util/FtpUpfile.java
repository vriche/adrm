package com.vriche.adrm.util;

/**
FTPԶ�������б�<br>
USER    PORT    RETR    ALLO    DELE    SITE    XMKD    CDUP    FEAT<br>
PASS    PASV    STOR    REST    CWD     STAT    RMD     XCUP    OPTS<br>
ACCT    TYPE    APPE    RNFR    XCWD    HELP    XRMD    STOU    AUTH<br>
REIN    STRU    SMNT    RNTO    LIST    NOOP    PWD     SIZE    PBSZ<br>
QUIT    MODE    SYST    ABOR    NLST    MKD     XPWD    MDTM    PROT<br>
 �ڷ�������ִ������,�����sendServer��ִ��Զ������(����ִ�б���FTP����)�Ļ�������FTP���Ҫ����\r\n<br>
      ftpclient.sendServer("XMKD /test/bb\r\n"); //ִ�з������ϵ�FTP����<br>
      ftpclient.readServerResponseһ��Ҫ��sendServer�����<br>
      nameList("/test")��ȡָĿ¼�µ��ļ��б�<br>
      XMKD����Ŀ¼����Ŀ¼���ڵ�������ٴδ���Ŀ¼ʱ����<br>
      XRMDɾ��Ŀ¼<br>
      DELEɾ���ļ�<br>
* <p>Title: ʹ��JAVA����FTP������(FTP�ͻ���)</p>
* <p>Description: �ϴ��ļ������ͼ��ļ���С���ŵ����ô���ķ�����ȥ��⣬����ŵ�ǰ̨JAVASCRIPT��ȥ����
* ���FTP�е����е���ʹ�õ��ļ����ĵط���ʹ��������·����������·����ʼ����
* </p>
* <p>Copyright: Copyright (c) 2005</p>
* <p>Company: ����������</p>
*  @author  ŷ����  13873195792
*  @version  1.0
*/ 

	import sun.net.ftp.*;
	import sun.net.*;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.ByteArrayOutputStream;
	import java.util.ArrayList;
	import java.util.StringTokenizer;

	
	public class FtpUpfile {
	    private FtpClient ftpclient;
	    private String ipAddress;
	    private int ipPort;
	    private String userName;
	    private String PassWord;
	   
	    public FtpUpfile(String ip, int port, String username, String password) throws
	            Exception {
	        ipAddress = new String(ip);
	        ipPort = port;
	        ftpclient = new FtpClient(ipAddress, ipPort);
	        //ftpclient = new FtpClient(ipAddress);
	        userName = new String(username);
	        PassWord = new String(password);
	    }

	   
	    public FtpUpfile(String ip, String username, String password) throws
	            Exception {
	        ipAddress = new String(ip);
	        ipPort = 21;
	        ftpclient = new FtpClient(ipAddress, ipPort);
	        //ftpclient = new FtpClient(ipAddress);
	        userName = new String(username);
	        PassWord = new String(password);
	    }


	   
	    public void login() throws Exception {
	        ftpclient.login(userName, PassWord);
	    }

	   
	    public void logout() throws Exception {
	        //��ftpclient.closeServer()�Ͽ�FTP����ʱ���¸�����˳�
	        ftpclient.sendServer("QUIT\r\n");

	        int reply = ftpclient.readServerResponse(); //ȡ�÷������ķ�����Ϣ
	    }
	    
	    public int getReadServerResponse() throws Exception {
	    	 return ftpclient.readServerResponse(); //ȡ�÷������ķ�����Ϣ
	    }
	  
	    
	    public void cd(String path) throws Exception {
	        ftpclient.ascii();
	        StringTokenizer s = new StringTokenizer(path, "/"); //sign
	   
	        ftpclient.sendServer("CDUP " + path + "\r\n");
	        int reply = ftpclient.readServerResponse();
	    }
	    
	    
	    public void del(String path) throws Exception {
	        ftpclient.ascii();
	        StringTokenizer s = new StringTokenizer(path, "/"); //sign
	   
	        ftpclient.sendServer("DELE " + path + "\r\n");
	        int reply = ftpclient.readServerResponse();
	    }
	    

	    /** */   /**
	     * ��FTP�������Ͻ���ָ����Ŀ¼,��Ŀ¼�Ѿ����ڵ����²���Ӱ��Ŀ¼�µ��ļ�,���������ж�FTP
	     * �ϴ��ļ�ʱ��֤Ŀ¼�Ĵ���Ŀ¼��ʽ������"/"��Ŀ¼��ͷ
	     *  @param  pathList String
	     *  @throws  Exception
	      */    
	    public void buildList(String pathList) throws Exception {
	        ftpclient.ascii();
	        StringTokenizer s = new StringTokenizer(pathList, "/"); //sign
	        int count = s.countTokens();
	        String pathName = "";
	        while (s.hasMoreElements()) {
	            pathName = pathName + "/" + (String) s.nextElement();
	            try {
	                ftpclient.sendServer("XMKD " + pathName + "\r\n");
	            } catch (Exception e) {
	                e = null;
	            }
	            int reply = ftpclient.readServerResponse();
	        }
	        ftpclient.binary();
	    }

	     /** */   /**
	     * ȡ��ָ��Ŀ¼�µ������ļ�����������Ŀ¼����
	     * ����nameList�õ����������е������õ�ָ��Ŀ¼�µ������ļ���
	     *  @param  fullPath String
	     *  @return  ArrayList
	     *  @throws  Exception
	      */    
	    public ArrayList fileNames(String fullPath) throws Exception {
	        ftpclient.ascii(); //ע�⣬ʹ���ַ�ģʽ
	        TelnetInputStream list = ftpclient.nameList(fullPath);
	        byte[] names = new byte[2048];
	        int bufsize = 0;
	        bufsize = list.read(names, 0, names.length); //�����ж�ȡ
	        list.close();
	        ArrayList namesList = new ArrayList();
	        int i = 0;
	        int j = 0;
	        while (i < bufsize ) {
	            //char bc = (char) names;
	            //System.out.println(i + "  " + bc + " : " + (int) names);
	            //i = i + 1;
	            if (names[i] == 10) { //�ַ�ģʽΪ10��������ģʽΪ13
	                //�ļ����������п�ʼ�±�Ϊj,i-jΪ�ļ����ĳ���,�ļ����������еĽ����±�Ϊi-1
	                //System.out.write(names, j, i - j);
	                //System.out.println(j + "   " + i + "    " + (i - j));
	                String tempName = new String(names, j, i - j);
	                namesList.add(tempName);
	                //System.out.println(temp);
	                // ������봦
	                //j = i + 2; //��һ��λ�ö�����ģʽ
	                j = i + 1; //��һ��λ���ַ�ģʽ
	            }
	            i = i + 1;
	        }
	        return namesList;
	    }

	       /** */   /**
	     * �ϴ��ļ���FTP������,destination·����FTP��������"/"��ʼ�����ļ�����
	     * �ϴ��ļ�ֻ��ʹ�ö�����ģʽ�����ļ�����ʱ�ٴ��ϴ���Ḳ��
	     *  @param  source String
	     *  @param  destination String
	     *  @throws  Exception
	      */ 
	    public void upFile(String source, String destination) throws Exception {
	        buildList(destination.substring(0, destination.lastIndexOf("/")));
	        ftpclient.binary(); //���д���������buildList֮��
	        TelnetOutputStream ftpOut = ftpclient.put(destination);
	        TelnetInputStream ftpIn = new TelnetInputStream(new
	                FileInputStream(source), true);
	        byte[] buf = new byte[204800];
	        int bufsize = 0;
	        while ((bufsize = ftpIn.read(buf, 0, buf.length)) != -1) {
	            ftpOut.write(buf, 0, bufsize);
	        }
	        ftpIn.close();
	        ftpOut.close();

	    }


	       /** */   /**
	     * JSP�е����ϴ���FTP������,
	     * �ϴ��ļ�ֻ��ʹ�ö�����ģʽ�����ļ�����ʱ�ٴ��ϴ���Ḳ��
	     * �ֽ�������Ϊ�ļ���������,�˷���������JSP��ͨ��
	     * request��������ֱ���ϴ��ļ���RequestUpload���е����˴˷�����
	     * destination·����FTP��������"/"��ʼ�����ļ���
	     *  @param  sourceData byte[]
	     *  @param  destination String
	     *  @throws  Exception
	      */ 
	    public void upFile(byte[] sourceData, String destination) throws Exception {
	        buildList(destination.substring(0, destination.lastIndexOf("/")));
	        ftpclient.binary(); //���д���������buildList֮��
	        TelnetOutputStream ftpOut = ftpclient.put(destination);
	        ftpOut.write(sourceData, 0, sourceData.length);
//	        ftpOut.flush();
	        ftpOut.close();
	    }

	       /** */   /**
	     * ��FTP�ļ��������������ļ�SourceFileName��������destinationFileName
	     * ���е��ļ����ж�Ҫ�����������·��������
	     *  @param  SourceFileName String
	     *  @param  destinationFileName String
	     *  @throws  Exception
	      */ 
	    public void downFile(String SourceFileName, String destinationFileName) throws
	            Exception {
	        ftpclient.binary(); //һ��Ҫʹ�ö�����ģʽ
	        TelnetInputStream ftpIn = ftpclient.get(SourceFileName);
	        byte[] buf = new byte[204800];
	        int bufsize = 0;
	        FileOutputStream ftpOut = new FileOutputStream(destinationFileName);
	        while ((bufsize = ftpIn.read(buf, 0, buf.length)) != -1) {
	            ftpOut.write(buf, 0, bufsize);
	        }
	        ftpOut.close();
	        ftpIn.close();
	    }

	       /** */   /**
	     *��FTP�ļ��������������ļ���������ֽ�������
	     *  @param  SourceFileName String
	     *  @return  byte[]
	     *  @throws  Exception
	      */ 
	    public byte[] downFile(String SourceFileName) throws
	            Exception {
	        ftpclient.binary(); //һ��Ҫʹ�ö�����ģʽ
	        TelnetInputStream ftpIn = ftpclient.get(SourceFileName);
	        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
	        byte[] buf = new byte[204800];
	        int bufsize = 0;

	        while ((bufsize = ftpIn.read(buf, 0, buf.length)) != -1) {
	            byteOut.write(buf, 0, bufsize);
	        }
	        byte[] return_arraybyte = byteOut.toByteArray();
	        byteOut.close();
	        ftpIn.close();
	        return return_arraybyte;
	    }

	       /** */   /**  ����ʾ��
	     * FtpUpfile fUp = new FtpUpfile("192.150.189.22", 21, "admin", "admin");
	     * fUp.login();
	     * fUp.buildList("/adfadsg/sfsdfd/cc");
	     * String destination = "/test.zip";
	     * fUp.upFile("C:\\Documents and Settings\\Administrator\\My Documents\\sample.zip",destination);
	     * ArrayList filename = fUp.fileNames("/");
	     * for (int i = 0; i < filename.size(); i++) {
	     *     System.out.println(filename.get(i).toString());
	     * }
	     * fUp.logout();
	     *  @param  args String[]
	     *  @throws  Exception
	      */  
	    public static void main(String[] args) throws Exception {
	        FtpUpfile fUp = new FtpUpfile("172.16.0.142", 22, "ivr", "ivr");
	        fUp.login();
	        /**/   /*          fUp.buildList("/adfadsg/sfsdfd/cc");
            String destination = "/test/SetupDJ.rar";
            fUp.upFile(
     "C:\\Documents and Settings\\Administrator\\My Documents\\SetupDJ.rar",
                    destination);
            ArrayList filename = fUp.fileNames("/");
            for (int i = 0; i < filename.size(); i++) {
                System.out.println(filename.get(i).toString());
            }

            fUp.downFile("/sample.zip", "d:\\sample.zip");
      */ 
	        FileInputStream fin = new FileInputStream(
	                "d:\\wapPush.txt");
	        byte[] data = new byte[20480000];
	        fin.read(data, 0, data.length);
	        fUp.upFile(data, "/home/cdr/wapPush.txt");
	        fUp.logout();
	        System.out.println("����������ɣ�");
	       
	       
	    }

}
