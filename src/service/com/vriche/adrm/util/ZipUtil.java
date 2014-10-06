package com.vriche.adrm.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.tools.zip.ZipOutputStream;

public class ZipUtil{

    private static int BUFFER = 2048;
    private static String ENCODING = "GBK";
    /** *//**
     * ѹ���ļ�
     * @param src Դ�ļ�/Ŀ¼
     * @param dest ѹ������ļ�/Ŀ¼
     */
    public static void zip(String src, String dest){
        System.out.println("����ѹ���ļ�����");
        File srcFile = new File(src);
        File destFile = new File(dest);
        if(destFile.isDirectory()){
            //����ѹ���ļ�����ȡ��ǰ�ļ�/Ŀ¼����Ϊѹ���ļ�����
            String name = srcFile.getName();
            System.out.println(name);
            name = name.indexOf(".")>0?name.substring(0,name.indexOf(".")):name;
            name = name+".zip";
            destFile = new File(destFile+"/"+name);
        }
        System.out.println(destFile.getAbsolutePath());
        zip(srcFile, destFile);
    }

    /** *//**
     * ѹ���ļ�
     * @param src
     * @param dest
     */
    public static void zip(File src, File dest){
        try{
            FileOutputStream fout = new FileOutputStream(dest);
            CheckedOutputStream chc = new CheckedOutputStream(fout, new CRC32());
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(chc));
            System.out.println("��ʼ�ݹ�ѹ������");
            zip(out,src,src.getName());
            out.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /** *//**
     * �ݹ�ѹ���ļ���
     * @param out �����
     * @param srcFile ѹ���ļ���
     * @param path ѹ���ļ�·��
     */
    public static void zip(ZipOutputStream out, File srcFile, String path){

        try{
            if (srcFile.isDirectory()){
                System.out.println("ѹ���ļ���"+srcFile.getName());
                File[] f = srcFile.listFiles();
                out.putNextEntry(new org.apache.tools.zip.ZipEntry(path + "/"));
                path = path.equals("") ? "" : path + "/";

                for (int i = 0; i < f.length; i++){
                    zip(out, f[i], path + f[i].getName());
                }
            } else{
                System.out.println("ѹ���ļ�"+path);
                out.putNextEntry(new org.apache.tools.zip.ZipEntry(path));
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        new FileInputStream(srcFile), "iso8859-1"));

                int c;
                while (-1 != (c = in.read())){
                    out.write(c);
                }
                in.close();
            }

        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

 

    /** *//**
     * �����ѹ��zip�ļ��ķ�����
     * δ��������ļ�������
     * @param zipFileName
     * @param outputDirectory
     */
    public static void unZip(String zipFileName, String outputDirectory){
        try{
            ZipInputStream in = new ZipInputStream(new BufferedInputStream(
                    new FileInputStream(zipFileName)));
            BufferedOutputStream bos = null;
            //��ȡZipInputStream�е�ZipEntry��Ŀ��һ��zip�ļ��п��ܰ������ZipEntry��
            //��getNextEntry�����ķ���ֵΪnull�������ZipInputStream��û����һ��ZipEntry��
            //��������ȡ��ɣ�
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null){
                System.out.println("unziping " + entry.getName());

                //������zip���ļ���ΪĿ¼���ĸ�Ŀ¼
                File f = new File(outputDirectory);
                f.mkdir();
                if (entry.isDirectory()){
                    String name = entry.getName();
                    name = name.substring(0, name.length() - 1);
                    System.out.println("name " + name);
                    f = new File(outputDirectory + File.separator + name);
                    f.mkdir();
                    System.out.println("mkdir " + outputDirectory
                            + File.separator + name);
                } else{
                    f = new File(outputDirectory + File.separator
                            + entry.getName());
                    f.createNewFile();
                    FileOutputStream out = new FileOutputStream(f);
                    bos = new BufferedOutputStream(out, BUFFER);
                    int b;
                    byte data[] = new byte[BUFFER];
                    while ((b = in.read(data, 0, BUFFER)) != -1){
                        bos.write(data, 0, b);
                    }
                    bos.close();
                }
            }
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /** *//**
     * ���û�������С
     * @param size
     */
    public static void setBuffer(int size){
        BUFFER = size;
    }

    /** *//**
     * �����ַ�����
     * @param size
     */
    public static void setEncoding(String  encoding){
        ENCODING = encoding;
    }

    public static void main(String[] args) throws IOException{

        String path = "d:/temp/";
        String path2 = "d:/temp/test.zip";
        String path3 = "d:/temp/";

        // ZipUtil.zip(path, path2);
        System.out.println("ѹ���ɹ���");
        ZipUtil.unZip(path2,path3);
        System.out.println("��ѹ�ɹ���");
    }

}
