package com.vriche.adrm.webapp.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vriche.adrm.util.StringUtil;

public class PrintServlet extends HttpServlet{
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	 

	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		 
	 
		 String contextPath = request.getContextPath();
		 String queryString = request.getQueryString();
		 String redirectPath = contextPath + "/reports/commonReportImpl?"+queryString;
		 String model = request.getParameter("model");
		 String className ="";
		 
//		 String reportType = request.getParameter("reportType");
//		 String matterNameForm =StringUtil.getURLDecoderStr(request.getParameter("matterNameForm"));
//		 String customerIdForm = request.getParameter("customerIdForm");	 
//		 String matterEditForm = StringUtil.getURLDecoderStr(request.getParameter("matterEditForm"));
//		 String matterTypeForm = request.getParameter("matterTypeForm");	
		 

		 
		 
//		 request.getSession().setAttribute("model",model);		 
//		 request.getSession().setAttribute("reportType",reportType);
//		 request.getSession().setAttribute("name",matterNameForm);
//		 request.getSession().setAttribute("customerId",customerIdForm);
//		 request.getSession().setAttribute("edit",matterEditForm);
//		 request.getSession().setAttribute("matterType",matterTypeForm);
		 
		 

		 System.out.println("getQueryString>>>>>>>>"+queryString);
		 System.out.println("redirectPath>>>>>>>>"+redirectPath);
		 
		 
//		 System.out.println("reportType>>>>>>>>"+reportType);
//		 System.out.println("matterNameForm>>>>>>>>"+matterNameForm);		 
//		 System.out.println("customerIdForm>>>>>>>>"+customerIdForm);
//		 System.out.println("matterEditForm>>>>>>>>"+matterEditForm);
//		 System.out.println("matterTypeForm>>>>>>>>"+matterTypeForm);
		 
		 

		if (model.equals("view")) {
			className = "PublishViewerApplet.class";
		} else if (model.equals("print")) {
			className = "PublishPrintApplet.class";
		} else {
			response.sendRedirect(redirectPath);
		}	
		 

		 
//		 System.out.println("contextPath>>>>>>>>"+contextPath);
		 
		 
		 try {
			 

//			String reportType = request.getParameter("reportType");
			 
			response.setContentType("text/html");
			
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.write("<HTML><HEAD><TITLE>统计报表</TITLE>"+ "</HEAD><BODY>");
			
//			out.write("<CENTER><a href=\""+ contextPath + "/merm/audienceRatList.jsp"+ "\">返 回</a>");
			
	
			out.write("<APPLET  name=\"mytest2\"  CODE =\""+ className +"\" CODEBASE =\""+contextPath+"/reports/applets\" ARCHIVE =\"jasperreports-1.2.8-applet.jar,report.jar\" WIDTH =\"100%\" HEIGHT =\"100%\">");
		
			out.write("</XMP>");
//			 写入PARAM标记
			out.write("<PARAM NAME = CODE VALUE =\""+ className +"\" >");
			out.write("<PARAM NAME = CODEBASE VALUE =\""+ contextPath +"/reports/applets\" >");
			out.write("<PARAM NAME = ARCHIVE VALUE =\"jasperreports-1.2.8-applet.jar,report.jar\" >");
			out.write("<PARAM NAME=\"type\" VALUE=\"application/x-java-applet;version=1.2.8\">");  
			out.write("<PARAM NAME=\"scriptable\" VALUE=\"false\">");
			out.write("<PARAM NAME =\"REPORT_URL\" VALUE =\""+ redirectPath +"\">");
			out.write("</APPLET>");
			
			out.write("</CENTER></BODY></HTML>");
			out.close();

		} catch (Exception e) {
			// 可以跳转出错页面
			e.printStackTrace();
		}
	 }

	
	
	

}
