﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.*" %>
<%@ page import="com.vriche.adrm.Constants" %>

<%
    int DataLen = request.getContentLength();
    if (DataLen > 0)
    {
		final int BufSize = 1024; //一次读写数据的缓冲区大小

        //打开写入文件
//        String FileName = request.getRealPath("grf") + "\\" + request.getParameter("report");
    
        String FileName = Constants.APPLACTION_MAP.get(Constants.REPORTS_TEMPLE_PATH2) + request.getParameter("report");

    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FileName >>>>>>>>>>>>>"+ FileName);
    	
        FileOutputStream fos = new FileOutputStream(FileName);
              
		//注意：要分批读写，不然在某些条件下对大数据(>8K)模板保存不成功
        //读出客户端发送的数据，并写入文件流
        byte[] DataBuf = new byte[BufSize];   
        ServletInputStream sif = request.getInputStream();
		int TotalReadedLen = 0;

		
        while (DataLen > TotalReadedLen)
        {
            int TheReadedlen = sif.read(DataBuf, 0, BufSize);
            if (TheReadedlen <= 0)
                break;
                
			fos.write(DataBuf, 0, TheReadedlen);
        
            TotalReadedLen += TheReadedlen;
        }

        fos.close();
    }
%>
 