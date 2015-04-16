package com.vriche.adrm.webapp.serlet;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dhtmlx.xml2excel.ExcelWriter;
import com.vriche.adrm.util.StringUtil;


@SuppressWarnings("serial")
public class DhtmlExcelGeneratorServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
//		   System.out.println("service>>>>>>>>>>>>strQueryString>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + req.getQueryString());   
//		 System.out.println("DhtmlExcelGeneratorServlet>yyyyyyyyyyyyyyyy>>>1111111111111");
		 
		String xml = StringUtil.getURLDecoderStr(req.getParameter("grid_xml"));
		

//		 System.out.println("DhtmlExcelGeneratorServlet xml          111 >yyyyyyyyyyyyyyyy>>>1111111111111"+ StringUtil.getURLDecoderStr(req.getParameter("grid_xml")));
//		 
//		 System.out.println("DhtmlExcelGeneratorServlet xml>yyyyyyyyyyyyyyyy>>>1111111111111"+req.getAttribute("grid_xml").toString());
		 
//		xml = URLDecoder.decode(xml, "UTF-8");
		
//		 System.out.println("DhtmlExcelGeneratorServlet URLDecoder>yyyyyyyyyyyyyyyy >>>1111111111111" + xml);
		ExcelWriter exw = new ExcelWriter();
//		exw.setFontSize(9);

		(exw).generate(xml, resp);
	}
//	public void service(HttpServletRequest req,	HttpServletResponse resp) throws IOException, ServletException
//	{
//		String xml = req.getParameter("grid_xml");
//		xml = URLDecoder.decode(xml, "UTF-8");
//		(new ExcelWriter()).generate(xml, resp);
//	}
}