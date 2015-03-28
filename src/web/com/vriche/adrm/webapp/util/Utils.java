package com.vriche.adrm.webapp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
        final String userAgent = request.getHeader("USER-AGENT");
        try {
            String finalFileName = null;
            if(StringUtils.contains(userAgent, "MSIE")){//IE�����
                finalFileName = URLEncoder.encode(fileName,"UTF8");
            }else if(StringUtils.contains(userAgent, "Mozilla")){//google,��������
                finalFileName = new String(fileName.getBytes(), "ISO8859-1");
            }else{
                finalFileName = URLEncoder.encode(fileName,"UTF8");//���������
            }
            response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");//��������һ�������������������ʾ�򣬶�����ֱ����������д�
        } catch (UnsupportedEncodingException e) {
        }
    }

}
