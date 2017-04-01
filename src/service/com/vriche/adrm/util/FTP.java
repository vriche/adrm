package com.vriche.adrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;

public class FTP {

	private String userName; // FTP ��¼�û���
	private String password; // FTP ��¼����
	private String ip; // FTP ��������ַIP��ַ
	private int port; // FTP �˿�
	private FTPClient ftpClient = null; // FTP �ͻ��˴���

	public FTP(String userName, String password, String ip, int port) {
		this.userName = userName;
		this.password = password;
		this.ip = ip;
		this.port = port;
	}

	public boolean connectServer() {
		boolean flag = true;
		if (ftpClient == null) {
			int reply;
			try {
				System.out.println("into ftpClient == null");
				ftpClient = new FTPClient();
				ftpClient.setControlEncoding("GBK"); // �ļ�������,Ĭ��ISO8859-1����֧������
				// System.out.println("encoding "+ftpClient.getControlEncoding());
				ftpClient.setDefaultPort(port);
				ftpClient.connect(ip);
				ftpClient.login(userName, password);
				System.out.println("Connected to " + ip);
				System.out.print(ftpClient.getReplyString());
				reply = ftpClient.getReplyCode();
				ftpClient.setDataTimeout(120000);
				// �����������˼����ÿ����������֮ǰ��ftp client����ftp
				// server��ͨһ���˿�����������ΪʲôҪ�������أ���Ϊftp
				// server����ÿ�ο�����ͬ�Ķ˿����������ݣ�������linux�ϣ����ڰ�ȫ���ƣ�����ĳЩ�˿�û�п��������Ծͳ�������
				ftpClient.enterLocalPassiveMode();

				if (!FTPReply.isPositiveCompletion(reply)) {
					ftpClient.disconnect();
					System.err.println("FTP server refused connection.");
					flag = false;
				}
			} catch (SocketException e) {
				flag = false;
				e.printStackTrace();
				System.err.println("��¼ftp������ " + ip + " ʧ��,���ӳ�ʱ��");
			} catch (IOException e) {
				flag = false;
				e.printStackTrace();
				System.err.println("��¼ftp������ " + ip + " ʧ�ܣ�FTP�������޷��򿪣�");
			}
		}
		System.out.println("��½ftp�������ɹ�" + ip);
		return flag;
	}

	public void listRemoteAllFiles(String path) {
		try {
			FTPListParseEngine f = ftpClient.initiateListParsing(path);

			while (f.hasNext()) {
				FTPFile[] files = f.getNext(5);
				for (FTPFile file : files) {
					disFile(file, path);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void disFile(FTPFile file, String path) {
		if (file.isDirectory() && !file.getName().equals(".") && !file.getName().equals("..")) {
			System.out.println(File.separator + file.getName());
			listRemoteAllFiles(path + File.separator + file.getName());
		} else if (!file.getName().equals(".") && !file.getName().equals("..")) {
			System.out.println(file.getName());
		}
	}

	public void closeConnect() {
		System.out.println("�ر�ftp������");
		try {
			if (ftpClient != null) {
				ftpClient.logout();
				ftpClient.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void downFile(String remotePath, String fileName, String localPath) {

		FTPFile[] fs;
		try {
			ftpClient.changeWorkingDirectory(remotePath);// ת�Ƶ�FTP������Ŀ¼
			fs = ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + File.separator
							+ ff.getName());

					FileOutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void upFile(String path, String filename, String localFilePath) {
		try {
			FileInputStream in = new FileInputStream(new File(localFilePath));
			ftpClient.changeWorkingDirectory(path);
			ftpClient.storeFile(filename, in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		FTP ftp = new FTP("lixin", "008357", "192.168.1.79", 21);
		ftp.connectServer();

		ftp.listRemoteAllFiles("/");
		// ftp.downFile("/���Ա���", "���Ա���.mmap", "D:\development\workspace\swing");
		// ftp.upFile("/���Ա���", "ZIP", "E:\����\save\zip");
		ftp.closeConnect();
	}
}
